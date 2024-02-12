package com.intuit.player.controller;

import com.intuit.player.dto.Player;
import com.intuit.player.dto.PlayerList;
import com.intuit.player.exception.custom.ResourceNotFoundException;
import com.intuit.player.exception.dto.ErrorResponse;
import com.intuit.player.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${apiPrefix:/api}/players")
@Tag(name = "/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Operation(summary = "Get players with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlayerList.class))}),
    })
    @RequestMapping(method = RequestMethod.GET)
    public PlayerList getAllPlayers(
            @Parameter(description = "Page size limit, must >= 1", required = true) @RequestParam(defaultValue = "50") @Min(1) Integer limit,
            @Parameter(description = "Page number, must >= 0", required = true) @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @Parameter(description = "Sort column names, should match the property name with PlayerEntity") @RequestParam(required = false) String[] sortCols,
            @Parameter(description = "If sort by descending direction") @RequestParam(required = false) Boolean desc
    ) {
        return playerService.getAllPlayers(page, limit, sortCols, desc);
    }

    @Operation(summary = "Get a player by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Player.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid player id provided",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))})
    })
    @RequestMapping(path = "/{playerId}", method = RequestMethod.GET)
    public Player getPlayerById(
            @Parameter(description = "Player id", required = true) @PathVariable String playerId
    ) {
        Player player = playerService.getPlayerById(playerId);
        if (player == null) {
            throw new ResourceNotFoundException("Player id [" + playerId + "] doesn't exist.");
        }
        return player;
    }
}
