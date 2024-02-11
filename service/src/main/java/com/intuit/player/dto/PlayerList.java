package com.intuit.player.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PlayerList {
    private List<Player> players;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private int limit;
    private int currentPageSize;
}
