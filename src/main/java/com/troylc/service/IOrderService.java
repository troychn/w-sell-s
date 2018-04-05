package com.troylc.service;

import com.troylc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单业务逻辑处理类
 * Created by troylc on 2018/4/5.
 */
public interface IOrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查找单个订单.
     */
    OrderDTO findOne(String orderId);

    /**
     * 查找订单.
     **/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单.
     **/
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单.
     **/
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单.
     **/
    OrderDTO pay(OrderDTO orderDTO);

    /**
     * 查找订单.
     **/
    Page<OrderDTO> findList(Pageable pageable);
}
