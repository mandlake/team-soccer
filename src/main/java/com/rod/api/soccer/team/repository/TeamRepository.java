package com.rod.api.soccer.team.repository;

import com.rod.api.soccer.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends TeamJpqlRepository, JpaRepository<Team, Long> {
    // 1. 전체 축구팀 목록을 팀이름 오름차순으로 출력
    List<Team> findAllByOrderByTeamNameAsc();

    // 7. 수원을 연고지로 하는 골키퍼 이름 출력
    List<Team> findByStadiumKeyAddress(String address);

    // 9. 서울팀 선수들 이름과 포지션과 키(cm표시)와 몸무게(kg표시)와 각 선수의 BMI지수를 출력하시오
    List<Team> findByStadiumKeyAddressOrderByPlayersPlayerNameAsc(String address);

}
