package com.rod.api.soccer.player.model;


import com.rod.api.soccer.team.model.Team;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "player")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"id"})
public class Player {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "player_id", nullable = false)
    private String playerId;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "e_player_name")
    private String ePlayerName;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "join_yyyy")
    private String joinYear;
    private String position;
    @Column(name = "back_no")
    private String backNo;
    private String nation;
    @Column(name = "birth_date")
    private String birthDate;
    private String solar;
    private String height;
    private String weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id",
            nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Team teamKey;

    @Builder(builderMethodName = "builder")
    public Player(Long id, String playerId, String playerName, String ePlayerName, String nickname, String joinYear, String position, String backNo, String nation, String birthDate, String solar, String height, String weight) {
        this.id = id;
        this.playerId = playerId;
        this.playerName = playerName;
        this.ePlayerName = ePlayerName;
        this.nickname = nickname;
        this.joinYear = joinYear;
        this.position = position;
        this.backNo = backNo;
        this.nation = nation;
        this.birthDate = birthDate;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
    }
}
