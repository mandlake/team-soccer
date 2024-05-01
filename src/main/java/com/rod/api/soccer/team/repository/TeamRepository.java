package com.rod.api.soccer.team.repository;

import com.rod.api.soccer.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends TeamJpqlRepository, JpaRepository<Team, Long> {
    List<Team> findAllByOrderByTeamName();
}
