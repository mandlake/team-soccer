package com.rod.api.soccer.stadium.service;

import com.rod.api.soccer.stadium.model.StadiumDTO;
import com.rod.api.soccer.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;

}
