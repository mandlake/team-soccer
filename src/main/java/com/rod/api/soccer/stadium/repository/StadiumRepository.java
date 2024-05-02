package com.rod.api.soccer.stadium.repository;

import com.rod.api.soccer.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long>, StadiumJpqlRepository {

    // 11. 팀과 연고지를 연결해서 출력하시오
    List<Stadium> findByTeamsIsNotNullOrderByAddressAsc();

    // 16. STADIUM 에 등록된 운동장 중에서 홈팀이 없는 경기장까지 전부 나오도록
    List<Stadium> findByTeamsIsEmpty();
}