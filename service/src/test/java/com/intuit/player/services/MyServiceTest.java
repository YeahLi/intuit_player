package com.intuit.player.services;

import com.intuit.player.daos.OddEvenDao;
import com.intuit.player.dtos.OddEvenRequest;
import com.intuit.player.dtos.OddEventResponse;
import com.intuit.player.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {MyService.class, OddEvenDao.class, Utils.class})
class MyServiceTest {
    @Autowired
    private MyService myService;

    @Test
    void isOddOrEvent() {
        OddEvenRequest request = new OddEvenRequest(4);
        OddEventResponse response = myService.isOddOrEvent(request);
        assertEquals("Even", response.getResult());
    }
}