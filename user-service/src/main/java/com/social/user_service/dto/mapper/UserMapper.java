package com.social.user_service.dto.mapper;

import com.social.user_service.dto.request.UserRequest;
import com.social.user_service.dto.response.UserResponse;
import com.social.user_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "isDeleted", constant = "false")
    User userRequestToUser(UserRequest userRequest);

    UserResponse userToUserResponse(User user);
}
