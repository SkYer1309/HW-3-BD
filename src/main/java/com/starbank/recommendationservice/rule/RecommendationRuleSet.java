package com.starbank.recommendationservice.rule;

import com.starbank.recommendationservice.dto.RecommendationDto;
import java.util.Optional;
import java.util.UUID;

public interface RecommendationRuleSet {
    Optional<RecommendationDto> check(UUID userId);
}