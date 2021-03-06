package com.donnatto.javatests.util;

public class StringUtil {

    public static boolean isEmpty(String string) {

        return string == null || string.equals("") || string.trim().length() == 0;
    }

    public static String repeat(String string, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("Negative times not allowed");
        }

        String result = "";

        for (int i = 0, n = times; i < n; i++) {
            result += string;
        }
        return result;
    }
}
