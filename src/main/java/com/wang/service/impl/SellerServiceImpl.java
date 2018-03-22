package com.wang.service.impl;

import com.wang.dataobject.SellerInfo;
import com.wang.repository.SellerInfoRepository;
import com.wang.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 汪刘德 on 2018/3/21.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {

        return repository.findByOpenid(openid);
    }
}
