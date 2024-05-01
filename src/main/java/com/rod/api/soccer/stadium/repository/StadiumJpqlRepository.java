package com.rod.api.soccer.stadium.repository;

import com.rod.api.soccer.stadium.model.Stadium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumJpqlRepository {
//    @Query("SELECT s FROM Stadium s JOIN FETCH s.teams")
//    List<Stadium> findAllTeamsWithStadiums();
}
