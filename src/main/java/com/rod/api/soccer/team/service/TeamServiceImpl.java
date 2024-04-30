package com.rod.api.soccer.team.service;

import com.rod.api.soccer.team.model.TeamDTO;
import com.rod.api.soccer.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService{
    private final TeamRepository teamRepository;

    @Override
    public List<TeamDTO> findAll() {
        return teamRepository.findAllByOrderByTeamName().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<TeamDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }
}
