package com.troylc.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * Created by troylc on 2018/4/5.
 */
public class KeyUtils {
    public static synchronized String gen() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
