package com.rod.api.soccer.schedule.repository;

import com.rod.api.soccer.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleJpqlRepository {

    // 14. 팀과 스타디움, 스케줄을 조인하여 2012년 3월 17일에 열린 각 경기의 팀이름, 스타디움, 어웨이팀 이름 출력
    // 18. 평균키가 인천 유나이티스팀('K04')의 평균키보다 작은 팀의 팀ID, 팀명, 평균키 추출
    List<Schedule> findByScheDate(String date);

    // 22. 2012년 5월 한달간 경기가 있는 경기장 조회
    List<Schedule> findByScheDateBetween(String startDate, String endDate);
}