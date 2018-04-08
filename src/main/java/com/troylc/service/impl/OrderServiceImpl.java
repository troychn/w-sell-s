package com.troylc.service.impl;

import com.troylc.dao.OrderDetailDao;
import com.troylc.dao.OrderMasterDao;
import com.troylc.dto.CartDTO;
import com.troylc.dto.OrderDTO;
import com.troylc.entity.OrderDetail;
import com.troylc.entity.OrderMaster;
import com.troylc.entity.ProductInfo;
import com.troylc.enums.OrderStatusEnums;
import com.troylc.enums.PayStatusEnums;
import com.troylc.enums.ResultEnums;
import com.troylc.exception.WSellSException;
import com.troylc.service.IOrderService;
import com.troylc.service.IProductService;
import com.troylc.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单业务逻辑处理类
 * Created by troylc on 2018/4/5.
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    private final IProductService productService;

    private final OrderDetailDao orderDetailDao;

    private final OrderMasterDao orderMasterDao;

    @Autowired
    public OrderServiceImpl(IProductService productService, OrderDetailDao orderDetailDao, OrderMasterDao orderMasterDao) {
        this.productService = productService;
        this.orderDetailDao = orderDetailDao;
        this.orderMasterDao = orderMasterDao;
    }


    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        BigDecimal orderAmount = new BigDecimal(0);
        String orderId = KeyUtils.gen();

        //1.查找商品列表
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (null == productInfo) {
                //没有该商品，抛出异常
                throw new WSellSException(ResultEnums.PRODUCT_NOT_FOUND);
            }

            //2.计算订单总额
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //3.订单详情入库
            BeanUtils.copyProperties(productInfo, orderDetail); //对象属性拷贝
            orderDetail.setDetailId(KeyUtils.gen());
            orderDetail.setOrderId(orderId);
            orderDetailDao.save(orderDetail);
        }

        //3.写入订单(orderMaster和orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);  //对象复制需放到设置变量值之前
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.NEW.getCode());
        orderMasterDao.save(orderMaster);

        //4.出库
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        //websock消息通知
        //webSocketService.sendMessage(orderDTO.getOrderId());

        return orderDTO;
    }

    /**
     * 查找单个订单.
     *
     * @param orderId
     */
    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    /**
     * 查找订单.
     *
     * @param buyerOpenid
     * @param pageable
     */
    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    /**
     * 取消订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 完结订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 支付订单.
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO pay(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 查找订单.
     *
     * @param pageable
     */
    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
