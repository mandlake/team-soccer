package com.rod.api.soccer.team.repository;

import com.rod.api.soccer.team.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamJpqlRepository {
    // 8. 서울팀 선수들 이름, 키, 몸무게 목록으로 출력
    @Query("SELECT p.playerName, COALESCE(NULLIF(p.height, ''), 0), COALESCE(NULLIF(p.weight, ''), 0)\n" +
            "FROM player p\n" +
            "JOIN p.teamKey t\n" +
            "WHERE t.regionName = '서울'\n" +
            "ORDER BY p.height DESC, p.weight DESC")
    List<Team> findByStadiumKeyAddressOrderByPlayersHeightDescWeightDesc(String address);
}
