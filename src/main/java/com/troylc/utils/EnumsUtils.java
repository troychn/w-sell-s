package com.troylc.utils;

import com.troylc.enums.CodeEnums;

/**
 * 通用获取枚举中的信息类
 * Created by troylc on 2018/4/5.
 */
public class EnumsUtils {

    private EnumsUtils() {
    }

    /**
     * 通用获取枚举中的code
     * @param code
     * @param enums 枚举类的类
     * @param <T>
     * @return
     */
    public static <T extends CodeEnums> T getEnumsByCode(Integer code, Class<T> enums) {
        for (T e : enums.getEnumConstants()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }
}
