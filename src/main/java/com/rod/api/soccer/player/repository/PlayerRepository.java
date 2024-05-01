package com.rod.api.soccer.player.repository;

import com.rod.api.soccer.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>, PlayerJpqlRepository{
}