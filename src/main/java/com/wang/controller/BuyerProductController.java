package com.wang.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wang.VO.ProductInfoVO;
import com.wang.VO.ProductVO;
import com.wang.VO.ResultVO;
import com.wang.dataobject.ProductCategory;
import com.wang.dataobject.ProductInfo;
import com.wang.service.CategoryService;
import com.wang.service.ProductService;
import com.wang.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 买家商品信息
 * Created by 汪刘德 on 2018/3/11.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        /*ResultVO resultVO=new ResultVO();
        ProductVO productVO=new ProductVO();
        ProductInfoVO productInfoVO=new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;*/


        /**查询所有上架商品*/
        List<ProductInfo> productInfoList=productService.findUpAll();
        /**查询到类目*/
        List<Integer> categoryTypeList=new ArrayList<>();
        for (ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);

        /**数据拼接,外面是ProductVO，里面是ProductInfoVO*/
        List<ProductVO> productVOList=new ArrayList<>();

        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    /**将productInfo复制给productInfoVO*/
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        /**ResultVO层拼接*/

        return ResultVOUtil.success(productVOList);
    }
}
