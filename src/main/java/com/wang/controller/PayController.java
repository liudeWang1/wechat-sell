package com.wang.controller;

import com.lly835.bestpay.model.PayResponse;
import com.wang.dto.OrderDTO;
import com.wang.enums.ResultEnum;
import com.wang.exception.SellException;
import com.wang.service.OrderService;
import com.wang.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by 汪刘德 on 2018/3/17.
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @RequestMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId, @RequestParam("returnUrl")String returnUrl, Map<String,Object> map){

        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        /**发起支付*/
        PayResponse payResponse=payService.create(orderDTO);

        map.put("payResponse",payResponse);

        return new ModelAndView("/pay/create",map);
    }


    @RequestMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){

        payService.notify(notifyData);

        /**返回给微信处理结果*/
        return new ModelAndView("pay/success");
    }
}
