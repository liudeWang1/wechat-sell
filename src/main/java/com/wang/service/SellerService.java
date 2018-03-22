package com.wang.service;

import com.wang.dataobject.SellerInfo;

/**
 * Created by 汪刘德 on 2018/3/21.
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
