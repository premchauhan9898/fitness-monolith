package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;
    @PostMapping
    public ResponseEntity<Activity> registerActivity(@RequestBody ActivityRequest activityRequest) {
        return ResponseEntity.ok(activityService.registerActivity(activityRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ActivityResponse>> getActivities(@PathVariable String userId) {
        return ResponseEntity.ok(activityService.getActivities(userId));
    }
}
