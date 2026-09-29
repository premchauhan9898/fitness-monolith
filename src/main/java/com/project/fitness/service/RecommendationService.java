package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public RecommendationResponse generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found: " + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity Not Found" + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        recommendationRepository.save(recommendation);

        return new RecommendationResponse(
                request.getUserId(),
                request.getActivityId(),
                request.getRecommendation(),
                request.getImprovements(),
                request.getSuggestions(),
                request.getSafety()
        );
    }

    public RecommendationResponse getRecommendation(String userId) {
        Recommendation response = recommendationRepository.findByUserId(userId);

        System.out.println(response);
        return new RecommendationResponse(
                response.getUserId(),
                response.getActivityId(),
                response.getRecommendation(),
                response.getImprovements(),
                response.getSuggestions(),
                response.getSafety()
        );
    }
}
