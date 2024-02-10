package com.intuit.player.daos;

import com.intuit.player.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {OddEvenDao.class, Utils.class})
class OddEvenDaoTest {
    @Autowired
    private OddEvenDao oddEvenDao;

    @Test
    void isOddOrEvent() {
        assertEquals("Even", oddEvenDao.isOddOrEvent(4));
    }
}