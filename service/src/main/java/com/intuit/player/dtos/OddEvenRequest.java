package com.intuit.player.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OddEvenRequest {
    Integer number;

    public OddEvenRequest(Integer number) {
        this.number = number;
    }
}
