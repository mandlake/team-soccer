package com.rod.api.soccer.team.service;

import com.rod.api.common.service.QueryService;
import com.rod.api.soccer.team.model.Team;
import com.rod.api.soccer.team.model.TeamDTO;

import java.util.List;

public interface TeamService extends QueryService<TeamDTO> {

    default Team dtoToEntity(TeamDTO dto){    //dto 를 entity로 바꾸는 것
        return Team.builder()
                .id(dto.getId())
                .regionName(dto.getRegionName())
                .teamName(dto.getTeamName())
                .eTeamName(dto.getETeamName())
                .origYyyy(dto.getOrigYyyy())
                .zipCode1(dto.getZipCode1())
                .zipCode2(dto.getZipCode2())
                .address(dto.getAddress())
                .ddd(dto.getDdd())
                .tel(dto.getTel())
                .fax(dto.getFax())
                .homepage(dto.getHomepage())
                .owner(dto.getOwner())
                .build();
    }

    default TeamDTO entityToDto(Team ent){ //entity 를 dto로 바꾸는 것
        return TeamDTO.builder()
                .id(ent.getId())
                .regionName(ent.getRegionName())
                .teamName(ent.getTeamName())
                .eTeamName(ent.getETeamName())
                .origYyyy(ent.getOrigYyyy())
                .zipCode1(ent.getZipCode1())
                .zipCode2(ent.getZipCode2())
                .address(ent.getAddress())
                .ddd(ent.getDdd())
                .tel(ent.getTel())
                .fax(ent.getFax())
                .homepage(ent.getHomepage())
                .owner(ent.getOwner())
                .build();
    }
}
