package com.realbizgames.demo.hazelcast.utils;

public class StringUtils {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }
}
