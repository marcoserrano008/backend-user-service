package com.social.user_service.controller;

import com.social.user_service.dto.request.UserRequest;
import com.social.user_service.dto.response.UserResponse;
import com.social.user_service.service.user.CreateUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserCreateController {

    private final CreateUserService createUserService;

    public UserCreateController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @Operation(summary = "Create a new user", description = "This API allows you to create a new user by sending a valid `UserRequest`.")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        UserResponse response = createUserService.createUser(request);
        return ResponseEntity.ok(response);
    }
}
