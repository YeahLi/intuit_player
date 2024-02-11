package com.intuit.player.controller;

import com.intuit.player.dto.Player;
import com.intuit.player.dto.PlayerList;
import com.intuit.player.exception.custom.ResourceNotFoundException;
import com.intuit.player.service.PlayerService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${apiPrefix}/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public PlayerList getAllPlayers(
            @RequestParam(defaultValue = "50") @Min(1) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam(required = false) String[] sortCols,
            @RequestParam(required = false) Boolean desc
    ) {
        return playerService.getAllPlayers(page, limit, sortCols, desc);
    }

    @RequestMapping(path = "/{playerId}", method = RequestMethod.GET)
    public Player getPlayerById(
            @PathVariable String playerId
    ) {
        Player player = playerService.getPlayerById(playerId);
        if (player == null) {
            throw new ResourceNotFoundException("Player id [" + playerId + "] doesn't exist.");
        }
        return player;
    }
}
