package com.rod.api.soccer.stadium.service;

import com.rod.api.soccer.stadium.model.StadiumDTO;
import com.rod.api.soccer.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository repository;

    @Override
    public List<StadiumDTO> findAll() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public Optional<StadiumDTO> findById(Long id) {
        return repository.findById(id).map(this::entityToDto);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Boolean existById(Long id) {
        return repository.existsById(id);
    }
}
