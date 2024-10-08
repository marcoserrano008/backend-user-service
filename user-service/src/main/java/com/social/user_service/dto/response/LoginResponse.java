package com.social.user_service.dto.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;

    private UserResponse userDetail;
}
