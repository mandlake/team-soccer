package com.rod.api.soccer.player.repository;

import com.rod.api.soccer.player.model.Player;
import com.rod.api.soccer.team.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerJpqlRepository {
    // 12. 수원팀(K02) 과 대전팀(K10) 선수들 중 키가 180 이상 183 이하인 선수들
    @Query("SELECT p.height, t.teamName, p.playerName " +
            "FROM team t " +
            "JOIN player p ON t.teamId = p.teamKey.teamId " +
            "WHERE t.teamId IN :teamIds " +
            "AND p.height BETWEEN :minHeight AND :maxHeight " +
            "ORDER BY p.height, t.teamName, p.playerName")
    List<Object[]> findByTeamKeyTeamIdInAndHeightBetween(@Param("teamIds") String teamIds, @Param("minHeight") Double minHeight, @Param("maxHeight") Double maxHeight);

    // 19. 포지션이 MF 인 선수들의 소속팀명 및 선수명, 백넘버 출력
    @Query("SELECT p.teamKey.teamId AS teamId, p.teamKey.teamName AS teamName, p.playerName AS playerName " +
            "FROM player p " +
            "WHERE p.position = :position " +
            "ORDER BY p.teamKey.teamName ASC, p.playerName ASC")
    List<Object[]> findByPositionOrderByTeamKeyTeamNameAscPlayerNameAsc(@Param("position") String position);

    // 21. 선수 자신이 속한 팀의 평균키보다 작은 선수 정보 출력
    @Query("SELECT p " +
            "FROM player p " +
            "WHERE p.teamKey = :team " +
            "AND CAST(p.height AS DOUBLE) < (SELECT AVG(CAST(p2.height AS DOUBLE)) " +
            "                FROM player p2 " +
            "                WHERE p2.teamKey = :team " +
            "                AND p2.height IS NOT NULL AND CAST(p2.height AS DOUBLE) <> 0) " +
            "AND p.height IS NOT NULL AND CAST(p.height AS DOUBLE) <> 0")
    List<Player> findByTeamKeyAndHeightLessThan(@Param("team") String team);
}
