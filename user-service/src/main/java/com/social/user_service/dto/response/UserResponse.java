package com.social.user_service.dto.response;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {

    private Long id;

    private Long accountId;

    private String username;

    private String firstName;

    private String lastName;

    private LocalDateTime createdDate;
}
