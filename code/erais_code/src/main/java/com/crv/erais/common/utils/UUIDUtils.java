package com.crv.erais.common.utils;

import java.util.UUID;

/**
 * 生成32位UUID
 */
public class UUIDUtils {

    public UUIDUtils() {
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }

    public static void main(String[] args) {
        String ss =getUUID();

            System.out.println(ss);

    }
}
