package com.starbank.recommendationservice.service;

import com.starbank.recommendationservice.dto.RecommendationDto;
import com.starbank.recommendationservice.dto.UserRecommendationResponse;
import com.starbank.recommendationservice.rule.RecommendationRuleSet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    private final List<RecommendationRuleSet> rules;

    public RecommendationService(List<RecommendationRuleSet> rules) {
        this.rules = rules;
    }

    public UserRecommendationResponse getRecommendations(UUID userId) {
        List<RecommendationDto> recommendations = rules.stream()
                .map(rule -> rule.check(userId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return new UserRecommendationResponse(userId, recommendations);
    }
}