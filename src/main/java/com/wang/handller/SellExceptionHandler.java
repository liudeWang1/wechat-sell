package com.wang.handller;

import com.wang.config.ProjectUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
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

}
