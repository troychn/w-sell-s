package com.troylc.utils;

import com.troylc.enums.ResultCodeEnums;
import com.troylc.vo.ResultObject;

/**
 * Created by troylc on 2018/3/28.
 */
public class ResultUtils {
    public static ResultObject success(Object data) {
        ResultObject resultVO = new ResultObject();
        resultVO.setCode(ResultCodeEnums.OK.getCode());
        resultVO.setData(data);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultObject success() {
        return success(null);
    }

    public static ResultObject error(Integer code, String msg) {
        ResultObject resultVO = new ResultObject();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

    public static ResultObject error(ResultCodeEnums resultCodeEnums) {
        ResultObject resultVO = new ResultObject();
        resultVO.setMsg(resultCodeEnums.getMsg());
        resultVO.setCode(resultCodeEnums.getCode());
        return resultVO;
    }
}
