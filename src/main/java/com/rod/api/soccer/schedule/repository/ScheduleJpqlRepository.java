package com.rod.api.soccer.schedule.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJpqlRepository {
    // 15. 2012년 3월 17일 경기에 포항 스틸러스 소속 골키퍼(GK) 선수, 포지션,팀명 (연고지포함), 스타디움, 경기날짜를 구하시오
    @Query("SELECT CONCAT(t.regionName, '[]', t.teamName), s.stadiumName, p.playerName, p.position " +
            "FROM schedule sc " +
            "JOIN sc.stadiumKey s " +
            "JOIN s.teams t " +
            "JOIN t.players p " +
            "WHERE t.teamName = ?1 AND sc.scheDate = ?2 AND p.position = ?3")
    List<Object[]> findTeamStadiumPlayerByTeamNameAndDateAndPosition(String teamName, String date, String position);
}
