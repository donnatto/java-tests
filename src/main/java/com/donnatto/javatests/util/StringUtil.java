package com.donnatto.javatests.util;

public class StringUtil {

    public static String repeat(String string, int times) {
        String result = "";

        for (int i = 0, n = times; i < n; i++) {
            result += string;
        }
        return result;
    }
}
