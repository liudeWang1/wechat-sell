package com.wang.exception;

import com.wang.enums.ResultEnum;

/**
 * Created by 汪刘德 on 2018/3/12.
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
