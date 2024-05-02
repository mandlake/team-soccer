package com.rod.api.soccer.player.web;

import ch.qos.logback.classic.Logger;
import com.rod.api.soccer.player.model.Player;
import com.rod.api.soccer.player.model.PlayerDto;
import com.rod.api.soccer.player.repository.PlayerRepository;
import com.rod.api.soccer.player.service.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/players")
@Slf4j
public class PlayerController {
    private final PlayerServiceImpl service;
    private final PlayerRouter router;

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "q") String q,
            @RequestParam(value = "playerName", required = false) String playerName,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "teamId1", required = false) String teamId1,
            @RequestParam(value = "teamId2", required = false) String teamId2,
            @RequestParam(value = "regionName", required = false) String regionName,
            @RequestParam(value = "height", required = false) String height,
            @RequestParam(value = "team1", required = false) String teamName1,
            @RequestParam(value = "team2", required = false) String teamName2,
            @RequestParam(value = "min", required = false) String min,
            @RequestParam(value = "max", required = false) String max
    ){
        log.info("Controller searchPlayer q is {}", q);
        List<?> o = router.execute(q,playerName,position,teamId1, teamId2,regionName,
                height, teamName1,teamName2,min,max);
        return ResponseEntity.ok(o);
    }
}
