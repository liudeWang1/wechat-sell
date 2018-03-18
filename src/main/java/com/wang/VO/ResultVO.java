package com.wang.VO;

import lombok.Data;

/**
 * Created by 汪刘德 on 2018/3/11.
 */
@Data
public class ResultVO<T> {

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;
}
