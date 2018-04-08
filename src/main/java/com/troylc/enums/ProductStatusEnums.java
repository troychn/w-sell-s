package com.troylc.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by troylc on 2018/3/27.
 */
@Getter
public enum ProductStatusEnums {

    UP(0, "在售"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
