package com.project.fitness.dto;

import com.project.fitness.model.Activity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationResponse {
    private String userId, activityId, recommendation;
    private List<String> improvements, suggestions, safety;

}
