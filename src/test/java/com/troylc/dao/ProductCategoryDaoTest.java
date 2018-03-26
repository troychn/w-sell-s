package com.troylc.dao;

import com.troylc.entity.ProductCategory;
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
 * Created by troylc on 2018/3/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao  productCategoryDao;

    @Test
    public void findone(){
        Optional<ProductCategory> productCategory = productCategoryDao.findById(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void save(){
        ProductCategory productCategory = new ProductCategory("你的最爱",3);
//        productCategory.setCategoryName("你的最爱");
//        productCategory.setCategoryType(3);

        productCategoryDao.save(productCategory);
    }

    
    @Test
    public void update(){
        Optional<ProductCategory> productCategorys = productCategoryDao.findById(1);
//        productCategory.setCategoryId(1);
        productCategorys.get().setCategoryName("我的最爱");
        productCategorys.get().setCategoryType(10);

        productCategoryDao.save(productCategorys.get());
    }


    @Test
    public void findByCategoryTypeIn() throws Exception {

        List<Integer> list = Arrays.asList(10,2,3);

        List<ProductCategory> productCategories = productCategoryDao.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,productCategories.size());
    }

}