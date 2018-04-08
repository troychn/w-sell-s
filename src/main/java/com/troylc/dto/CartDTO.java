package com.troylc.dto;

import lombok.Data;

/**
 * 购物车数据传输对象
 * Created by troylc on 2018/4/8.
 */
@Data
public class CartDTO {
    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
