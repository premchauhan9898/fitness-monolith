package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<RecommendationResponse> getRecommendation(@PathVariable String userId) {
        return ResponseEntity.ok(service.getRecommendation(userId));
    }
}
