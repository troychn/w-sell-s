package com.troylc.vo;

import lombok.Data;

/**
 * Created by troylc on 2018/3/27.
 */
@Data
public class ResultObject<T> {
    /**
     * 返回状态码 0表示成功，1表示失败
     */
     private Integer code;

    /**
     * 返回信息
     */
     private String msg;

    /**
     * 返回对象
     */
     private T data;
}
