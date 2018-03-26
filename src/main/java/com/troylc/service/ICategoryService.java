package com.troylc.service;

import com.troylc.entity.ProductCategory;

import java.util.List;

/**
 * 类目service层
 * Created by troylc on 2018/3/26.
 */
public interface ICategoryService {

    /**
     * 根据ID查询目录对象
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目数据
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 根据类目的list数据，查询类目信息
     *
     * @param categoryTypeList
     * @return categoryTypeLists集合
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存与更新
     * @param productCategory
     * @return
     */
    ProductCategory saveOrUpdate(ProductCategory productCategory);
}
