package com.troylc.exception;

import com.troylc.enums.ResultEnums;

/**
 * 异常处理类
 * Created by troylc on 2018/4/5.
 */
public class WSellSException extends RuntimeException {

    /**
     * 错误状态码.
     */
    private Integer code;

    public WSellSException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public WSellSException(ResultEnums resultEnums, String msg) {
        super(msg);
        this.code = resultEnums.getCode();
    }
}
