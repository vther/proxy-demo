package com.vther.proxy.demo._00_common.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
    public static void sleep(long millSceonds) {
        try {
            TimeUnit.MILLISECONDS.sleep(millSceonds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
