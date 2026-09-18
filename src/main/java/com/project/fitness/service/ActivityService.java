package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ActivityService {
    public final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public Activity registerActivity(ActivityRequest activityRequest) {
        return activityRepository.save(mapToActivity(activityRequest));
    }

    public Activity mapToActivity(ActivityRequest request) {

        User user = userRepository.findById(request.getUserId()).
                orElseThrow(RuntimeException::new);


        return Activity.builder()
                .type(request.getType())
                .user(user)
                .additionalMatrix(request.getAdditionalMatrix())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .duration(request.getDuration())
                .build();
    }

    public List<ActivityResponse> getActivities(String userId) {

        List<Activity> activities = activityRepository.findByUserId(userId);

        return activities.
                stream().map(this::mapToActivityResponse).toList();

    }

    private ActivityResponse mapToActivityResponse(Activity activity) {
        return new ActivityResponse(
                activity.getId(),
                activity.getDuration(),
                activity.getCaloriesBurned(),
                activity.getStartTime(),
                activity.getAdditionalMatrix(),
                activity.getType()
                );
    }
}
