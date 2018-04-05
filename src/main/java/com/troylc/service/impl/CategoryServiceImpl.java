package com.troylc.service.impl;

import com.troylc.dao.ProductCategoryDao;
import com.troylc.entity.ProductCategory;
import com.troylc.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类目业务服务层
 * Created by troylc on 2018/3/26.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ProductCategoryDao productCategoryDao;

    @Autowired
    public CategoryServiceImpl(ProductCategoryDao productCategoryDao) {
        this.productCategoryDao = productCategoryDao;
    }

    /**
     * 根据ID查询目录对象
     *
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findById(categoryId).get();
    }

    /**
     * 查询所有类目数据
     *
     * @return
     */
    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    /**
     * 根据类目的list数据，查询类目信息
     *
     * @param categoryTypeList
     * @return categoryTypeLists集合
     */
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    /**
     * 保存与更新
     *
     * @param productCategory
     * @return
     */
    @Override
    public ProductCategory saveOrUpdate(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
