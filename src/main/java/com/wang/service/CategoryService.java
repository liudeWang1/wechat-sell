package com.wang.service;

import com.wang.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by 汪刘德 on 2018/3/11.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
