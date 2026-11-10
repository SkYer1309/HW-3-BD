package com.starbank.recommendationservice.controller;

import com.starbank.recommendationservice.dto.UserRecommendationResponse;
import com.starbank.recommendationservice.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RecommendationController {
    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/recommendation/{user_id}")
    public ResponseEntity<UserRecommendationResponse> getRecommendations(@PathVariable("user_id") UUID userId) {
        UserRecommendationResponse response = service.getRecommendations(userId);
        return ResponseEntity.ok(response);
    }
}