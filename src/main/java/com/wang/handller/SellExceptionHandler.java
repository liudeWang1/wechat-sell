package com.wang.handller;

import com.wang.VO.ResultVO;
import com.wang.config.ProjectUrlConfig;
import com.wang.exception.SellException;
import com.wang.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 汪刘德 on 2018/3/22.
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:127.0.0.1/sell/seller/login");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

}
