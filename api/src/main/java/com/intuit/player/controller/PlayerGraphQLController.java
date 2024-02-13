package com.intuit.player.controller;

import com.intuit.player.dto.Player;
import com.intuit.player.dto.PlayerList;
import com.intuit.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerGraphQLController {
    private final PlayerService playerService;

    @Autowired
    public PlayerGraphQLController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public Player playerById(@Argument String playerId) {
        return playerService.getPlayerById(playerId);
    }

    @QueryMapping
    public PlayerList players(
            @Argument Integer limit,
            @Argument Integer page,
            @Argument List<String> sortCols, //java must be List not array
            @Argument Boolean desc
    ) {
        String[] cols = null;
        if (sortCols != null) {
            cols = new String[sortCols.size()];
            sortCols.toArray(cols);
        }
        return playerService.getAllPlayers(page, limit, cols, desc);
    }
}
