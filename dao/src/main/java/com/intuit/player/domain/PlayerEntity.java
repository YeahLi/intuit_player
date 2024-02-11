package com.intuit.player.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_player")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {
    @Id
    @Column(name = "id")
    @Size(max = 50)
    private String id;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "birth_month")
    @Min(1)
    @Max(12)
    private Integer birthMonth;

    @Column(name = "birth_day")
    @Min(1)
    @Max(31)
    private Integer birthDay;

    @Column(name = "birth_country")
    @Size(max = 100)
    private String birthCountry;

    @Column(name = "birth_state")
    @Size(max = 100)
    private String birthState;

    @Column(name = "birth_city")
    @Size(max = 100)
    private String birthCity;

    @Column(name = "death_year")
    private Integer deathYear;

    @Column(name = "death_month")
    @Min(1)
    @Max(12)
    private Integer deathMonth;

    @Column(name = "death_day")
    @Min(1)
    @Max(31)
    private Integer deathDay;

    @Column(name = "death_country")
    @Size(max = 100)
    private String deathCounty;

    @Column(name = "death_state")
    @Size(max = 100)
    private String deathState;

    @Column(name = "death_city")
    @Size(max = 100)
    private String deathCity;

    @Column(name = "name_first")
    @Size(max = 100)
    private String nameFirst;

    @Column(name = "name_last")
    @Size(max = 100)
    private String nameLast;

    @Column(name = "name_given")
    @Size(max = 200)
    private String nameGiven;

    @Column(name = "weight")
    @Min(0)
    private Integer weight;

    @Column(name = "height")
    @Min(0)
    private Integer height;

    @Column(name = "bats")
    private String batsHand;

    @Column(name = "throws")
    private String throwsHand;

    @Column(name = "debut")
    private Date debut;

    @Column(name = "final_game")
    private Date finalGame;

    @Column(name = "retro_id")
    @Size(max = 50)
    private String retroId;

    @Column(name = "bbref_id")
    @Size(max = 50)
    private String bbrefId;
}
