package com.rod.api.soccer.stadium.model;

import com.rod.api.soccer.schedule.model.Schedule;
import com.rod.api.soccer.team.model.Team;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Entity
@Table(name = "stadium")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString(exclude = {"id"})
@Log4j2
public class Stadium {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stadium_id", nullable = false)
    private String stadiumId;


    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "hometeam_id", nullable = false)
    private String hometeamKey;

    @Column(name = "seat_count", nullable = false)
    private int seatCount;

    private String address;
    private String ddd;
    private String tel;

    @OneToMany(mappedBy = "stadiumKey",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Team> teams;

    @OneToMany(mappedBy = "stadiumKey",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Schedule> schedules;

    @Builder(builderMethodName = "builder")
    public Stadium(Long id, String stadiumId, String stadiumName, String hometeamKey, int seatCount, String address, String ddd, String tel) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.hometeamKey = hometeamKey;
        this.seatCount = seatCount;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
    }
}
