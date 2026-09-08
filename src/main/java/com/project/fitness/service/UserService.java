package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User register(RegisterRequest registerRequest) {

        LocalDateTime now = LocalDateTime.now();
        User user = new User(
                "xx01",
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                now,
                now,
                List.of(),
                List.of()
                );

        return userRepository.save(user);
    }
}
