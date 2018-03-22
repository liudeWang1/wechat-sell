package com.wang.form;

import lombok.Data;

/**
 * Created by 汪刘德 on 2018/3/20.
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
