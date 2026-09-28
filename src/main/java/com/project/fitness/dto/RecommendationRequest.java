package com.project.fitness.dto;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecommendationRequest {
    private String userId, activityId;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}
