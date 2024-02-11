package com.intuit.player.dao;

import com.intuit.player.domain.PlayerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = {PlayerRepository.class})
@EntityScan("com.intuit.player.*")
@EnableJpaRepositories("com.intuit.player.*")
@EnableAutoConfiguration
@ActiveProfiles("test")
class PlayerRepositoryIT {
    @Autowired
    private PlayerRepository playerDao;

    @Test
    @Transient
    public void testFindById() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Optional<PlayerEntity> playerEntity = playerDao.findById("aardsda01");
        Assertions.assertTrue(playerEntity.isPresent());
        //aardsda01,1981,12,27,USA,CO,Denver,,,,,,,David,Aardsma,David Allan,215,75,R,R,2004-04-06,2015-08-23,aardd001,aardsda01
        Assertions.assertEquals("aardsda01", playerEntity.get().getId());
        Assertions.assertEquals(1981, playerEntity.get().getBirthYear());
        Assertions.assertEquals(12, playerEntity.get().getBirthMonth());
        Assertions.assertEquals(27, playerEntity.get().getBirthDay());
        Assertions.assertEquals("USA", playerEntity.get().getBirthCountry());
        Assertions.assertEquals("CO", playerEntity.get().getBirthState());
        Assertions.assertEquals("Denver", playerEntity.get().getBirthCity());
        Assertions.assertTrue(StringUtils.isBlank(playerEntity.get().getDeathCity()));
        Assertions.assertEquals("David", playerEntity.get().getNameFirst());
        Assertions.assertEquals("Aardsma", playerEntity.get().getNameLast());
        Assertions.assertEquals("David Allan", playerEntity.get().getNameGiven());
        Assertions.assertEquals(215, playerEntity.get().getWeight());
        Assertions.assertEquals(75, playerEntity.get().getHeight());
        Assertions.assertEquals("R", playerEntity.get().getBatsHand());
        Assertions.assertEquals("R", playerEntity.get().getThrowsHand());
        Assertions.assertEquals("2004-04-06", sdf.format(playerEntity.get().getDebut()));
        Assertions.assertEquals("2015-08-23", sdf.format(playerEntity.get().getFinalGame()));
        Assertions.assertEquals("aardd001", playerEntity.get().getRetroId());
        Assertions.assertEquals("aardsda01", playerEntity.get().getBbrefId());
    }

    @Test
    @Transient
    public void testFindAll() {
        List<PlayerEntity> playerEntities = playerDao.findAll();
        Assertions.assertEquals(4, playerEntities.size());
    }
}