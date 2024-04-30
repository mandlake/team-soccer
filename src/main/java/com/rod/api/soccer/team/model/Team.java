package com.rod.api.soccer.team.model;


import com.rod.api.soccer.player.model.Player;
import com.rod.api.soccer.stadium.model.Stadium;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "team")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@ToString(exclude = {"id", "players"})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "team_id")
    private String teamId;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "e_team_name")
    private String eTeamName;

    @Column(name = "orig_yyyy")
    private String origYyyy;

    @Column(name = "zip_code1")
    private String zipCode1;

    @Column(name = "zip_code2")
    private String zipCode2;

    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sta_id",
            nullable = true,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Stadium stadiumKey;

    @OneToMany(mappedBy = "teamKey",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Player> players = new ArrayList<>(); // 초기화

    @Builder(builderMethodName = "builder")
    public Team(Long id, String teamId, String regionName, String teamName, String eTeamName, String origYyyy, String zipCode1, String zipCode2, String address, String ddd, String tel, String fax, String homepage, String owner) {
        this.id = id;
        this.teamId = teamId;
        this.regionName = regionName;
        this.teamName = teamName;
        this.eTeamName = eTeamName;
        this.origYyyy = origYyyy;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
        this.fax = fax;
        this.homepage = homepage;
        this.owner = owner;
    }
}
