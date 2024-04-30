package com.rod.api.soccer.stadium.repository;

import com.rod.api.soccer.stadium.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

}
