package com.social.user_service.service.auth;

import com.social.user_service.dto.mapper.UserMapper;
import com.social.user_service.dto.request.LoginRequest;
import com.social.user_service.dto.response.LoginResponse;
import com.social.user_service.entity.User;
import com.social.user_service.repository.UserRepository;
import com.social.user_service.security.CustomUserDetails;
import com.social.user_service.security.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {

    private final JwtTokenUtil jwtTokenUtil;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    public LoginServiceImp(JwtTokenUtil jwtTokenUtil,
                           AuthenticationManager authenticationManager,
                           UserRepository userRepository) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(userDetails);

        Long userId = userDetails.getUserId();
        Optional<User> user = userRepository.findById(userId);

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setUserDetail(UserMapper.mapper.userToUserResponse(user.get()));

        return response;
    }
}
