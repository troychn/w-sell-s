package com.troylc.entity;

import com.troylc.enums.OrderStatusEnums;
import com.troylc.enums.PayStatusEnums;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 * Created by troylc on 2018/3/28.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    /**订单id*/
    private String orderId;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 买家手机号码
     */
    private String buyerPhone;

    /**
     * 买家送货地址
     */
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    private String buyerOpenid;

    /**
     * 订单总额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态 ,默认为0新下单
     */
    private Integer orderStatus = OrderStatusEnums.NEW.getCode();

    /**
     * 支付状态，默认为0未支付
     */
    private Integer payStatus = PayStatusEnums.NEW.getCode();

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
