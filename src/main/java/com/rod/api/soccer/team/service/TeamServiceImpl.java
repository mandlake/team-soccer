package com.rod.api.soccer.team.service;

import com.rod.api.soccer.team.model.TeamDTO;
import com.rod.api.soccer.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;

    @Override
    public List<TeamDTO> findAll() {
        return repository.findAllByOrderByTeamNameAsc().stream().map(this::entityToDto).toList();
    }

    @Override
    public Optional<TeamDTO> findById(Long id) {
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
