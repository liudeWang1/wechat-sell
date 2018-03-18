package com.wang.repository;

import com.wang.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by 汪刘德 on 2018/3/9.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest(){

        /*ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("开学季");
        productCategory.setCategoryType(3);
        repository.save(productCategory);*/
        //构造方法写的
        /*ProductCategory productCategory=new ProductCategory("男生最爱",3);
        ProductCategory result=repository.save(productCategory);
        Assert.assertNotNull(result);*/
        ProductCategory productCategory=repository.findOne(6);
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(2,3,4,5);
        List<ProductCategory> result =repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}