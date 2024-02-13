package com.intuit.player.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intuit.player.domain.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private String id;

    private Integer birthYear;

    private Integer birthMonth;

    private Integer birthDay;

    private String birthCountry;

    private String birthState;

    private String birthCity;

    private Integer deathYear;

    private Integer deathMonth;

    private Integer deathDay;

    private String deathCountry;

    private String deathState;

    private String deathCity;

    private String nameFirst;

    private String nameLast;

    private String nameGiven;

    private Integer weight;

    private Integer height;

    @JsonProperty("bats")
    private String batsHand;

    @JsonProperty("throws")
    private String throwsHand;

    private String debut;

    private String finalGame;

    private String retroId;

    private String bbrefId;

    public Player(PlayerEntity playerEntity) {
        this(
            playerEntity.getId(),
            playerEntity.getBirthYear(),
            playerEntity.getBirthMonth(),
            playerEntity.getBirthDay(),
            playerEntity.getBirthCountry(),
            playerEntity.getBirthState(),
            playerEntity.getBirthCity(),
            playerEntity.getDeathYear(),
            playerEntity.getDeathMonth(),
            playerEntity.getDeathDay(),
            playerEntity.getDeathCountry(),
            playerEntity.getDeathState(),
            playerEntity.getDeathCity(),
            playerEntity.getNameFirst(),
            playerEntity.getNameLast(),
            playerEntity.getNameGiven(),
            playerEntity.getWeight(),
            playerEntity.getHeight(),
            playerEntity.getBatsHand(),
            playerEntity.getThrowsHand(),
            DATE_FORMAT.format(playerEntity.getDebut()),
            DATE_FORMAT.format(playerEntity.getFinalGame()),
            playerEntity.getRetroId(),
            playerEntity.getBbrefId()
        );
    }
}
