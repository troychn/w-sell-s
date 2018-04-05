package com.troylc.dao;

import com.troylc.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by troylc on 2018/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void save() throws Exception{
        ProductInfo productInfo = new ProductInfo("123456", "挖掘机", new BigDecimal(32000.00),
                10, "战斗机", "http://XXXXXX.jpg", 0, 10);
        ProductInfo product = productInfoDao.save(productInfo);
        Assert.assertNotNull(product);
    }

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfos = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }

}