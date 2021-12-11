package com.madbad.jwt.chat_jwt.service;

import com.madbad.jwt.chat_jwt.model.ApiUser;
import com.madbad.jwt.chat_jwt.repository.UserRepository;
import com.madbad.jwt.chat_jwt.request.UserCreateRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public ApiUser readUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
    public void createUser(UserCreateRequest userCreateRequest) {
        ApiUser user = new ApiUser();
        Optional<ApiUser> byUsername = userRepository.findByUsername(userCreateRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }
        user.setUsername(userCreateRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        userRepository.save(user);
    }
}
