package com.wang.enums;

import lombok.Getter;

/**
 * Created by 汪刘德 on 2018/3/12.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0,"新订单"),
    FINISHED(1,"已完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
