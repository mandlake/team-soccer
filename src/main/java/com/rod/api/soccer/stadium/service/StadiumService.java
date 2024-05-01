package com.rod.api.soccer.stadium.service;

import com.rod.api.common.service.QueryService;
import com.rod.api.soccer.stadium.model.Stadium;
import com.rod.api.soccer.stadium.model.StadiumDTO;

public interface StadiumService extends QueryService<StadiumDTO> {
    default Stadium dtoToEntity(StadiumDTO dto) {
        return Stadium.builder()
                .id(dto.getId())
                .stadiumId(dto.getStadiumId())
                .stadiumName(dto.getStadiumName())
                .hometeamKey(dto.getHometeamKey())
                .seatCount(dto.getSeatCount())
                .address(dto.getAddress())
                .ddd(dto.getDdd())
                .tel(dto.getTel())
                .build();
    }

    default StadiumDTO entityToDto(Stadium ent) {
        return StadiumDTO.builder()
                .id(ent.getId())
                .stadiumId(ent.getStadiumId())
                .stadiumName(ent.getStadiumName())
                .hometeamKey(ent.getHometeamKey())
                .seatCount(ent.getSeatCount())
                .address(ent.getAddress())
                .ddd(ent.getDdd())
                .tel(ent.getTel())
                .build();
    }

}
