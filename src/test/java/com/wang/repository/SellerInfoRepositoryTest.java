package com.wang.repository;

import com.wang.dataobject.SellerInfo;
import com.wang.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 汪刘德 on 2018/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() throws Exception{
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("112233");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOpenid() throws Exception {

        SellerInfo result = repository.findByOpenid("112233");
        Assert.assertEquals("112233", result.getOpenid());
    }

}