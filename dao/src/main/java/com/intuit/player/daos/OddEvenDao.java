package com.intuit.player.daos;

import com.intuit.player.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class OddEvenDao {
    private final Utils utils;

    @Autowired
    public OddEvenDao(Utils utils) {
        this.utils = utils;
    }

    public String isOddOrEvent(Integer number) {
        return utils.isEvenOrOdd(number);
    }
}
