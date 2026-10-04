package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@AllArgsConstructor
public class RecommendationController {
    private RecommendationService service;
    @PostMapping
    public ResponseEntity<RecommendationResponse> generateRecommendation(@RequestBody RecommendationRequest request) {
        return ResponseEntity.ok(service.generateRecommendation(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendation(@PathVariable String userId) {
        return ResponseEntity.ok(service.getUserRecommendation(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<RecommendationResponse> getActivityRecommendation(@PathVariable String activityId) {
        return ResponseEntity.ok(service.getActivityRecommendation(activityId));
    }


}
