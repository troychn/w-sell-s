package com.troylc.service.impl;

import com.troylc.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by troylc on 2018/3/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategories = categoryService.findAll();
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(10, 1, 2));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void saveOrUpdate() throws Exception {
        ProductCategory productCategory = new ProductCategory("老男人的力量", 1);
        ProductCategory category = categoryService.saveOrUpdate(productCategory);
        Assert.assertNotNull(category);
    }

}