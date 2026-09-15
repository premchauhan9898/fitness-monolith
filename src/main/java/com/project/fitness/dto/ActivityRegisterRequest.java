package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRegisterRequest {
    private String userId;
    private ActivityType type;
    private Map<String, Object> additionalMatrix;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
}
