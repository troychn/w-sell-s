package com.troylc.dao;

import com.troylc.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情dao
 * Created by troylc on 2018/3/28.
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    /**
     * 根据订单id获取订单详情
     *
     * @param orderId
     * @return
     */
    public List<OrderDetail> findByOrderId(String orderId);

}