package com.rod.api.soccer.schedule.model;

import com.rod.api.soccer.stadium.model.Stadium;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "schedule")
@Getter
@ToString(exclude = {"id", "stadiumKey"})
public class Schedule {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="sche_id", nullable = false)
    private String scheId;

    @Column(name = "sche_date")
    private String scheDate;

    @Column(name = "gubun")
    private String gubun;

    @Column(name = "hometeam_key")
    private String hometeamKey;

    @Column(name = "awayteam_key")
    private String awayteamKey;

    @Column(name = "home_score")
    private int homeScore;

    @Column(name = "away_score")
    private int awayScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sta_id",
            nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Stadium stadiumKey; // Stadium과의 매핑

    @Builder(builderMethodName = "builder")
    public Schedule(Long id, String scheId, Stadium stadiumKey, String scheDate, String gubun, String hometeamKey, String awayteamKey, int homeScore, int awayScore ) {
        this.id = id;
        this.scheId = scheId;
        this.stadiumKey = stadiumKey;
        this.scheDate = scheDate;
        this.gubun = gubun;
        this.hometeamKey = hometeamKey;
        this.awayteamKey = awayteamKey;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}