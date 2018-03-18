package com.wang.service;

import com.wang.dataobject.ProductInfo;
import com.wang.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 汪刘德 on 2018/3/11.
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    //后端查询商品需要分页
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);


    /**加库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /**减库存*/
    void decreaseStock(List<CartDTO> cartDTOList);
}
