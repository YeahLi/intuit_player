package com.intuit.player.dao;

import com.intuit.player.domain.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, String> {
}
