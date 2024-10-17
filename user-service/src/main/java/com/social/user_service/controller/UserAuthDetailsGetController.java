package com.social.user_service.controller;

import com.social.user_service.dto.response.UserAuthDetailResponse;
import com.social.user_service.entity.User;
import com.social.user_service.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserAuthDetailsGetController {

    private final UserRepository userRepository;

    public UserAuthDetailsGetController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Operation(summary = "Get user authentication details by username",
            description = "Retrieve authentication details such as username and password by providing the username. Returns 404 if the user is not found.")
    @GetMapping("/username/{username}")
    public ResponseEntity<UserAuthDetailResponse> getAuthUserDetails(@PathVariable String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserAuthDetailResponse response = new UserAuthDetailResponse(user.get().getUsername(),
                                                                     user.get().getPassword(),
                                                                     new ArrayList<>());
        return ResponseEntity.ok(response);
    }
}
