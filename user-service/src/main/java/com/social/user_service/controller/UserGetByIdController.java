package com.social.user_service.controller;

import com.social.user_service.dto.response.UserResponse;
import com.social.user_service.service.user.GetUserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserGetByIdController {

    private final GetUserService getUserService;

    public UserGetByIdController(GetUserService getUserService) {
        this.getUserService = getUserService;
    }

    @Operation(summary = "Get a user by ID",
            description = "Retrieve user details by providing the user's unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {
        UserResponse response = getUserService.getUserById(id);
        return ResponseEntity.ok(response);
    }
}
