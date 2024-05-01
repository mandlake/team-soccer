package com.rod.api.soccer.player.web;

import com.rod.api.soccer.player.repository.PlayerRepository;

import java.util.List;
import java.util.Map;

public class PlayerRouter {
    private PlayerRepository repository;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> execute(String query) {
        return switch (query) {
            case "1" -> null;
            case "2" -> null;
            case "3" -> null;
            case "4" -> null;
            default -> null;
        };
    }
}
