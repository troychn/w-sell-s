package com.troylc.enums;

import lombok.Getter;

/**
 * 支付状态
 * Created by troylc on 2018/3/28.
 */
@Getter
public enum PayStatusEnums implements CodeEnums<Integer> {
    NEW(0, "未支付"),
    FINISH(1, "已支付");

    private Integer code;

    private String msg;

    PayStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}