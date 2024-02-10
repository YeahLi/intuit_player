package com.intuit.player.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Utils.class)
class UtilsTest {
    @Autowired
    private Utils utils;

    @Test
    void isEvenOrOdd() {
        String res = utils.isEvenOrOdd(5);
        Assertions.assertEquals("Odd", res);
    }
}