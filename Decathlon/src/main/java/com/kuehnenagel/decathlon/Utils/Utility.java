package com.kuehnenagel.decathlon.Utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utility {

    public static int INDEX_NAME = 0;
    public static int INDEX_100_M = 1;
    public static int INDEX_LONG_JUMP = 2;
    public static int INDEX_SHOT_PUT = 3;
    public static int INDEX_HIGH_JUMP = 4;
    public static int INDEX_400_M = 5;
    public static int INDEX_100_M_HURDLES = 6;
    public static int INDEX_DISCUS_THROW = 7;
    public static int INDEX_POLE_VAULT = 8;
    public static int INDEX_JAVELIN_THROW = 9;
    public static int INDEX_1500_M = 10;

    private final static String INFO = "---INFO--- ";
    private final static String ERROR = "---ERROR--- ";

    public static void showInfo(String message, Object... params) {
        System.out.println(
                String.format(INFO.concat(message), params)
        );
    }

    public static void showError(String message, Object... params) {
        System.out.println(
                String.format(ERROR.concat(message), params)
        );
    }

}
