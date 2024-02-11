package com.intuit.player.util;

import java.util.function.Supplier;

public class Utils {
    public static <T> T safeGet(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }
}
