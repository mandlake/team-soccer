package com.rod.api.soccer.player.web;

import com.rod.api.soccer.player.model.PlayerDto;
import com.rod.api.soccer.player.service.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerServiceImpl service;

    @GetMapping(path = "/search")
    public ResponseEntity<List<PlayerDto>> searchPlayer(@RequestParam String search) {
        return null;
    }

}
