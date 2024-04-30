package com.rod.api.soccer.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ScheduleDTO {
    private Long id;
    private String scheId;
    private String scheDate;
    private String gubun;
    private String hometeamKey;
    private String awayteamKey;
    private int homeScore;
    private int awayScore;
}
