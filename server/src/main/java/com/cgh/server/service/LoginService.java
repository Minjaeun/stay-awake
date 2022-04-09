package com.cgh.server.service;

import com.cgh.server.domain.User;
import com.cgh.server.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByNameAndPassword(String name, String password) {
        return userRepository.existsByNameAndPassword(name, password);
    }

    public Optional<User> findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }
}
