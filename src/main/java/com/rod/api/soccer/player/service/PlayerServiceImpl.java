package com.rod.api.soccer.player.service;

import com.rod.api.soccer.player.model.PlayerDto;
import com.rod.api.soccer.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{


    private final PlayerRepository playerRepository;

    @Override
    public List<PlayerDto> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<PlayerDto> findById(Long id) {
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
