package com.intuit.player.service;

import com.intuit.player.dao.PlayerRepository;
import com.intuit.player.domain.PlayerEntity;
import com.intuit.player.dto.Player;
import com.intuit.player.dto.PlayerList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {PlayerRepository.class, PlayerService.class})
@EntityScan("com.intuit.player.*")
@EnableJpaRepositories("com.intuit.player.*")
@EnableAutoConfiguration
@ActiveProfiles("test")
class PlayerServiceIT {
    @Autowired
    private PlayerService playerService;

    @Test
    @Transient
    void getPlayerById() {
        Player player = playerService.getPlayerById("aardsda01");
        
        Assertions.assertNotNull(player);
        Assertions.assertEquals("aardsda01", player.getId());
        Assertions.assertEquals(1981, player.getBirthYear());
        Assertions.assertEquals(12, player.getBirthMonth());
        Assertions.assertEquals(27, player.getBirthDay());
        Assertions.assertEquals("USA", player.getBirthCountry());
        Assertions.assertEquals("CO", player.getBirthState());
        Assertions.assertEquals("Denver", player.getBirthCity());
        Assertions.assertTrue(StringUtils.isBlank(player.getDeathCity()));
        Assertions.assertEquals("David", player.getNameFirst());
        Assertions.assertEquals("Aardsma", player.getNameLast());
        Assertions.assertEquals("David Allan", player.getNameGiven());
        Assertions.assertEquals(215, player.getWeight());
        Assertions.assertEquals(75, player.getHeight());
        Assertions.assertEquals("R", player.getBatsHand());
        Assertions.assertEquals("R", player.getThrowsHand());
        Assertions.assertEquals("2004-04-06", player.getDebut());
        Assertions.assertEquals("2015-08-23", player.getFinalGame());
        Assertions.assertEquals("aardd001", player.getRetroId());
        Assertions.assertEquals("aardsda01", player.getBbrefId());
    }

    @Test
    @Transient
    void getPlayerByIdWithNonExistId() {
        Player player = playerService.getPlayerById("xxxxyyy");
        Assertions.assertNull(player);
    }

    @Test
    @Transient
    void getAllPlayers() {
        //test limit only
        PlayerList players = playerService.getAllPlayers(0, 3, null, null);
        Assertions.assertEquals(4, players.getTotalElements());
        Assertions.assertEquals(2, players.getTotalPages());
        Assertions.assertEquals(3, players.getCurrentPageSize());

        players = playerService.getAllPlayers(1, 3, null, null);
        Assertions.assertEquals(1, players.getCurrentPageSize());

        players = playerService.getAllPlayers(3, 3, null, null);
        Assertions.assertEquals(0, players.getCurrentPageSize());
    }

    @Test
    @Transient
    void getAllPlayersWithSortAsc() {
        //test sort asc
        PlayerList players = playerService.getAllPlayers(0, 20, new String[]{"birthYear", "finalGame"}, null);
        Assertions.assertEquals(4, players.getTotalElements());
        Assertions.assertEquals(1, players.getTotalPages());
        Assertions.assertEquals(4, players.getCurrentPageSize());

        int prevYear = 0;
        for (Player player : players.getPlayers()) {
            Assertions.assertTrue(player.getBirthYear() >= prevYear);
            prevYear = player.getBirthYear();
        }
    }

    @Test
    @Transient
    void getAllPlayersWithSortDesc() {
        //test sort asc
        PlayerList players = playerService.getAllPlayers(0, 20, new String[]{"birthYear"}, true);
        Assertions.assertEquals(4, players.getTotalElements());
        Assertions.assertEquals(1, players.getTotalPages());
        Assertions.assertEquals(4, players.getCurrentPageSize());

        int prevYear = 9999;
        for (Player player : players.getPlayers()) {
            Assertions.assertTrue(player.getBirthYear() <= prevYear);
            prevYear = player.getBirthYear();
        }
    }
}