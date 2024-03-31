package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    public List<User> listAllActiveUsers() {
        return userRepository.findAllActiveUsers();
    }

    public Optional<User> listUserById(int userId) {
        return userRepository.findById(userId);
    }

    public List<User> listAllInactiveUsers() {
        return userRepository.findAllInactiveUsers();
    }

    @Transactional
    public void updateUserScore(int score, int userId) {
        userRepository.saveUserScore(score, userId);
    }
}
