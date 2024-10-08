package com.social.user_service.service.user;

import com.social.user_service.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface GetUserService {

    UserResponse getUserById(Long userId);
}
