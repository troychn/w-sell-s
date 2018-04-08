package com.troylc.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * 格式： 时间+随机数
 * Created by troylc on 2018/4/5.
 */
public class KeyUtils {
    /**
     * 多并发的时候，需要对订单ID加上synchronized,以防止多并发时生成的ID一样
     * @return
     */
    public static synchronized String gen() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
