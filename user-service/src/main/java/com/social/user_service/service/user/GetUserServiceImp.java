package com.social.user_service.service.user;

import com.social.user_service.dto.mapper.UserMapper;
import com.social.user_service.dto.response.UserResponse;
import com.social.user_service.entity.User;
import com.social.user_service.exception.UserNotFoundException;
import com.social.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GetUserServiceImp implements GetUserService {

    private final UserRepository userRepository;

    public GetUserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserMapper.mapper::userToUserResponse)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %s was not found", userId)));
    }
}
