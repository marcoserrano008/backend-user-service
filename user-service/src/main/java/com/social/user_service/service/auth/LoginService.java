package com.social.user_service.service.auth;

import com.social.user_service.dto.request.LoginRequest;
import com.social.user_service.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse login(LoginRequest request);
}
