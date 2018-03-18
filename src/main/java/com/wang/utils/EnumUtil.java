package com.wang.utils;

import com.wang.enums.CodeEnum;

/**
 * Created by 汪刘德 on 2018/3/18.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){

        for (T each:enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
