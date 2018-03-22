package com.wang.controller;

import com.wang.constant.CookieConstant;
import com.wang.constant.RedisConstant;
import com.wang.dataobject.SellerInfo;
import com.wang.enums.ResultEnum;
import com.wang.service.SellerService;
import com.wang.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by 汪刘德 on 2018/3/21.
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("openid")String openid, HttpServletResponse response, Map<String,Object> map){

        //openid和数据库里的openid匹配
        SellerInfo sellerInfo=sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo==null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        /**
         * 设置token至redis
         */
        String token= UUID.randomUUID().toString();
        Integer expire= RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS);

        /**
         * 设置token至cookie
         */
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:/seller/order/list");
    }


    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map){
        /**
         * 从cookie里查询
         */
        Cookie cookie=CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie!=null){
            /**
             * 清除redis
             */
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            /**
             * 清除cookie
             */
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);

    }

}
