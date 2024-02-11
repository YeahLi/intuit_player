package com.intuit.player.service;

import com.intuit.player.dao.PlayerRepository;
import com.intuit.player.domain.PlayerEntity;
import com.intuit.player.dto.Player;
import com.intuit.player.dto.PlayerList;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerDao;

    @Autowired
    public PlayerService(PlayerRepository playerDao) {
        this.playerDao = playerDao;
    }

    public Player getPlayerById(String id) {
        Optional<PlayerEntity> playerOptional = playerDao.findById(id);
        if (playerOptional.isPresent()) {
            PlayerEntity playerEntity = playerOptional.get();
            return new Player(playerEntity);
        }
        return null;
    }

    public PlayerList getAllPlayers(Integer page, Integer limit, String[] sortCols, Boolean desc)
    {
        //build sort request
        Sort sort = null;
        if (!Arrays.isNullOrEmpty(sortCols)) {
            if (desc != null && desc) {
                sort = Sort.by(sortCols).descending();
            } else {
                sort = Sort.by(sortCols);
            }
        }

        //build pagination
        Pageable pageable;
        if (sort == null) {
           pageable = PageRequest.of(page, limit);
        } else {
           pageable = PageRequest.of(page, limit, sort);
        }

        Page<Player> res  = playerDao.findAll(pageable).map(Player::new);
        return PlayerList.builder()
                .players(res.getContent())
                .currentPage(res.getNumber())
                .currentPageSize(res.getNumberOfElements())
                .totalPages(res.getTotalPages())
                .totalElements(res.getTotalElements())
                .limit(res.getSize())
                .build();
    }
}
