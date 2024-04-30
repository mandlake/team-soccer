package com.rod.api.soccer.player.model;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
@Data
@Builder
@Getter
@Setter
public class PlayerDto {
    private Long id;
    private String playerId;
    private String playerName;
    private String ePlayerName;
    private String nickname;
    private String joinYear;
    private String position;
    private String backNo;
    private String nation;
    private String birthDate;
    private String solar;
    private String height;
    private String weight;
//    private String teamKey; 외래키 연결 필요
    private Long teamkey;
}
