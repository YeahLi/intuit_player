package com.intuit.player.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public String isEvenOrOdd(Integer number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }
}
