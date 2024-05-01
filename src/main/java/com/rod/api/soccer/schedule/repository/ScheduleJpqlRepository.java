package com.rod.api.soccer.schedule.repository;

import com.rod.api.soccer.schedule.model.Schedule;
import com.rod.api.soccer.stadium.model.Stadium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleJpqlRepository {
//    @Query("SELECT s FROM schedule s WHERE s.scheDate = :date")
//    List<Schedule> findGamesInfoByDate(@Param("date") String date);
//
//    @Query("SELECT s FROM schedule s WHERE s.id = :gameId")
//    Schedule findPlayerInfoForSpecificGame(@Param("gameId") Long gameId);
//
//    @Query("SELECT s FROM schedule s WHERE ABS(s.homeScore - s.awayScore) >= 3")
//    List<Schedule> findGamesWithLargeScoreDifference();
//
//    @Query("SELECT s.stadiumKey FROM schedule s WHERE s.stadiumKey.hometeamKey IS NULL")
//    List<Stadium> findStadiumsWithoutHomeTeam();
//
//    @Query("SELECT s.stadiumKey FROM schedule s WHERE s.scheDate LIKE '201205%'")
//    List<Stadium> findStadiumsWithGamesInMay2012();
}
