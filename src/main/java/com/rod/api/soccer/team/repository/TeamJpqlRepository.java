package com.rod.api.soccer.team.repository;

import com.rod.api.soccer.team.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamJpqlRepository {
//    @Query("SELECT t FROM team t JOIN FETCH t.players p WHERE AVG(p.height) < (SELECT AVG(p2.height) FROM player p2 WHERE p2.teamKey.teamId = t.teamId) AND t.regionName = '인천'")
//    List<Team> findTeamsWithAverageHeightLowerThanIncheon();
}
