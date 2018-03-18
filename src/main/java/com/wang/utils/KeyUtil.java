package com.wang.utils;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Random;

/**
 * Created by 汪刘德 on 2018/3/12.
 */
public class KeyUtil {
    /**
     *  生成主键
     * 格式：时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();

        //产生6位的随机数
        Integer number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
