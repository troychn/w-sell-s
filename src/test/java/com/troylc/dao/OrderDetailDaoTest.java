package com.troylc.dao;

import com.troylc.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by troylc on 2018/4/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("http://xxxxx.jpg");
        OrderDetail result = orderDetailDao.save(orderDetail);

        Assert.assertEquals("123456", orderDetail.getDetailId());
    }

    @Test
    public void findByOrderIdTest() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("123456");

        Assert.assertNotNull(orderDetailList);
    }

}