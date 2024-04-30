package com.rod.api.soccer.player.service;

import com.rod.api.common.service.QueryService;
import com.rod.api.soccer.player.model.Player;
import com.rod.api.soccer.player.model.PlayerDto;

public interface PlayerService extends QueryService<PlayerDto> {

    default Player dtoToEntity(PlayerDto dto) {
        return Player.builder()
                .id(dto.getId())
                .playerName(dto.getPlayerName())
                .ePlayerName(dto.getEPlayerName())
                .nickname(dto.getNickname())
                .joinYear(dto.getJoinYear())
                .position(dto.getPosition())
                .backNo(dto.getBackNo())
                .nation(dto.getNation())
                .birthDate(dto.getBirthDate())
                .solar(dto.getSolar())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .build();
    }

    default PlayerDto entityToDto(Player ent) {
        return PlayerDto.builder()
                .id(ent.getId())
                .playerName(ent.getPlayerName())
                .ePlayerName(ent.getEPlayerName())
                .nickname(ent.getNickname())
                .joinYear(ent.getJoinYear())
                .position(ent.getPosition())
                .backNo(ent.getBackNo())
                .nation(ent.getNation())
                .birthDate(ent.getBirthDate())
                .solar(ent.getSolar())
                .height(ent.getHeight())
                .weight(ent.getWeight())
                .build();
    }
}
