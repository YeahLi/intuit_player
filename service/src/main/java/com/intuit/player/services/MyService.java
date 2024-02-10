package com.intuit.player.services;

import com.intuit.player.daos.OddEvenDao;
import com.intuit.player.dtos.OddEvenRequest;
import com.intuit.player.dtos.OddEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final OddEvenDao oddEvenDao;

    @Autowired
    public MyService(OddEvenDao oddEvenDao) {
        this.oddEvenDao = oddEvenDao;
    }

    public OddEventResponse isOddOrEvent(OddEvenRequest request) {
        String result = oddEvenDao.isOddOrEvent(request.getNumber());
        return new OddEventResponse(result);
    }
}
