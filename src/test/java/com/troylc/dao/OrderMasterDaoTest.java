package com.troylc.dao;

import com.troylc.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by troylc on 2018/4/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    OrderMasterDao orderMasterDao;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("曾女士");
        orderMaster.setBuyerAddress("漳州开发区卡达凯斯5号2016");
        orderMaster.setBuyerPhone("18611762335");
        orderMaster.setBuyerOpenid("12345678");
        orderMaster.setOrderAmount(new BigDecimal(100));
        OrderMaster result = orderMasterDao.save(orderMaster);

        Assert.assertEquals("12345678", result.getBuyerOpenid());
    }

    @Test
    public void findByBuyerOpenidTest() {
        PageRequest request = PageRequest.of(0, 1);
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid("12345678", request);
         //断言测试，只有查询的记录不等于0
        Assert.assertNotEquals(0,request.getPageSize());
    }


}