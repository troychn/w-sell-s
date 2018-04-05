package com.troylc.enums;

import lombok.Getter;

/**
 * 返回状态
 * Created by troylc on 2018/3/28.
 */
@Getter
public enum ResultCodeEnums {

    OK(0,"成功"),
    ERROR(-1,"失败");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态码信息
     */
    private String msg;

    ResultCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
