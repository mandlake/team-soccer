package com.rod.api.soccer.schedule.repository;

import com.rod.api.soccer.schedule.model.Schedule;
import com.rod.api.soccer.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleJpqlRepository {
}