package com.intuit.player.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OddEventResponse {
    String result;

    public OddEventResponse(String result) {
        this.result = result;
    }
}
