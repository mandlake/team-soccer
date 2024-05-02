package com.rod.api.soccer.player.web;

import com.rod.api.soccer.player.model.Player;
import com.rod.api.soccer.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PlayerRouter {
    private final PlayerRepository repository;


    public List<?> execute(String q, String playerName, String position,
                                      String teamId1, String teamId2, String regionName, String height,
                                      String teamName1, String teamName2, String minHeight, String maxHeight){


        return switch (q){
            case "2" -> repository.findDistinctByPosition(position);
            case "3" -> repository.findByPositionNotNull();
            case "4" -> repository.findByTeamKeyTeamIdAndPosition(teamId1, position);
            case "5" -> repository.findByTeamKeyTeamIdAndPlayerNameStartingWithAndHeightGreaterThanEqual(teamId1, playerName, height);
            case "10" -> repository.findByTeamKeyTeamIdOrTeamKeyTeamIdAndPosition(teamId1, teamId2, position);
            case "13" -> repository.findByPositionNullOrderByTeamKeyTeamNameAscPlayerNameAsc();
            case "12" -> repository.findByTeamKeyTeamIdInAndHeightBetween(teamId1, Double.parseDouble(minHeight),Double.parseDouble(maxHeight));
            case "19" -> repository.findByPositionOrderByTeamKeyTeamNameAscPlayerNameAsc(position);
            case "21" -> repository.findByTeamKeyAndHeightLessThan(teamId1);
            default -> null;
        };
    }
}
