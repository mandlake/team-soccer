package com.rod.api.soccer.stadium.model;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Builder
@Getter
public class StadiumDTO {
    private Long id;
    private String stadiumId;
    private String stadiumKey;
    private String stadiumName;
    private String hometeamKey;
    private int seatCount;
    private String address;
    private String ddd;
    private String tel;
}
