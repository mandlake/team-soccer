package com.rod.api.soccer.schedule.service;

import com.rod.api.common.service.QueryService;
import com.rod.api.soccer.schedule.model.Schedule;
import com.rod.api.soccer.schedule.model.ScheduleDTO;

public interface ScheduleService {
    default Schedule dtoToEntity(ScheduleDTO dto){
        return Schedule.builder()
                .id(dto.getId())
                .scheDate(dto.getScheDate())
                .gubun(dto.getGubun())
                .hometeamKey(dto.getHometeamKey())
                .awayteamKey(dto.getAwayteamKey())
                .homeScore(dto.getHomeScore())
                .awayScore(dto.getAwayScore())
                .build();
    }

    default ScheduleDTO entityToDto(Schedule ent){
        return ScheduleDTO.builder()
                .id(ent.getId())
                .scheDate(ent.getScheDate())
                .gubun(ent.getGubun())
                .hometeamKey(ent.getHometeamKey())
                .awayteamKey(ent.getAwayteamKey())
                .homeScore(ent.getHomeScore())
                .awayScore(ent.getAwayScore())
                .build();
    }
}
