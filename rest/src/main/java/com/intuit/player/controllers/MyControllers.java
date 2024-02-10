package com.intuit.player.controllers;

import com.intuit.player.dtos.OddEvenRequest;
import com.intuit.player.dtos.OddEventResponse;
import com.intuit.player.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllers {

    private final MyService myService;

    @Autowired
    public MyControllers(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public OddEventResponse test(
            @RequestBody OddEvenRequest request
        ) {
        return myService.isOddOrEvent(request);
    }
}
