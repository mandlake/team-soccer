package com.rod.api.soccer.player.repository;

import com.rod.api.soccer.player.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerJpqlRepository {
//    @Query("SELECT DISTINCT p.position FROM player p")
//    List<String> findAllDistinctPlayerPositions();
//
//    @Query("SELECT DISTINCT CASE WHEN p.position = '' THEN '신입' ELSE p.position END FROM player p")
//    List<String> findAllDistinctPlayerPositionsOrDefault();
//
//    @Query("SELECT p FROM player p WHERE p.teamKey.teamId = :teamId AND p.position = 'GK'")
//    List<Player> findAllGoalkeepersByTeamId(@Param("teamId") String teamId);
//
//    @Query("SELECT p FROM player p WHERE p.playerName LIKE CONCAT(:surname, '%') AND TO_NUMBER(p.height) >= 170")
//    List<Player> findAllPlayersBySurnameAndHeight(@Param("surname") String surname);
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE t.teamId = :teamId AND p.position = 'MF'")
//    List<Player> findAllMidfieldersForSpecificTeams(@Param("teamId") String teamId);
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE t.regionName = '수원' AND p.position = 'GK'")
//    List<Player> findGoalkeeperByHometownForSuwon();
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE t.regionName = '서울'")
//    List<Player> findAllPlayersInfoForSeoulTeam();
//
//    @Query("SELECT p, ROUND(TO_NUMBER(p.weight) / ((TO_NUMBER(p.height) / 100) * (TO_NUMBER(p.height) / 100)), 1) AS BMI FROM player p JOIN FETCH p.teamKey t WHERE t.regionName = '서울'")
//    List<Player> findAllPlayersInfoWithBMIForSeoulTeam();
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE (t.teamId = 'K02' OR t.teamId = 'K10') AND p.position = 'GK'")
//    List<Player> findAllGoalkeepersForSuwonAndDaejeon();
//
//    @Query("SELECT p FROM player p WHERE p.position = ''")
//    List<Player> findAllPlayersWithoutPosition();
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE t.teamName = '드래곤즈' AND p.position = 'MF'")
//    List<Player> findMidfieldersInfo();
//
//    @Query("SELECT p FROM player p ORDER BY p.height DESC")
//    List<Player> findTallestPlayersInfo();
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE t.teamId IN ('K02', 'K10') AND TO_NUMBER(p.height) < (SELECT AVG(p2.height) FROM player p2 WHERE p2.teamKey.teamId = t.teamId)")
//    List<Player> findShorterPlayersThanTeamAverage();
//
//    @Query("SELECT p FROM player p JOIN FETCH p.teamKey t WHERE (t.teamId = 'K02' OR t.teamId = 'K10') AND TO_NUMBER(p.height) >= 170")
//    List<Player> findAllPlayersByHeightForSuwonAndDaejeon();
}
