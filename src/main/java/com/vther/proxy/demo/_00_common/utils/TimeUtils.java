package com.vther.proxy.demo._00_common.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
    public static void sleep(long millSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(millSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
