package com.social.user_service.service.user;

import com.social.user_service.dto.mapper.UserMapper;
import com.social.user_service.dto.request.UserRequest;
import com.social.user_service.dto.response.UserResponse;
import com.social.user_service.entity.User;
import com.social.user_service.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserServiceImp implements CreateUserService{

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public CreateUserServiceImp(UserRepository userRepository,
                                BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserResponse createUser(UserRequest request) {
        User user = UserMapper.mapper.userRequestToUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return UserMapper.mapper.userToUserResponse(user);
    }
}
