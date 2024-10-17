package com.social.user_service.controller;

import com.social.user_service.dto.request.LoginRequest;
import com.social.user_service.dto.response.LoginResponse;
import com.social.user_service.service.auth.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Operation(summary = "User login",
            description = "Authenticate a user by providing login credentials and receive a token if successful.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse>createAuthenticationToken(@Valid @RequestBody LoginRequest loginRequest) {
        LoginResponse response = this.loginService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
