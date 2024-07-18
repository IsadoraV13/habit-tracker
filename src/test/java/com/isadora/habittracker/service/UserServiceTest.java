package com.isadora.habittracker.service;

import com.isadora.habittracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private HabitService habitService;


    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void updateUserScore() {

//        Mockito.doNothing().when(userRepository).saveUserScore(isA(Integer.class), isA(Integer.class));
        userService.updateUserScore(33,1);

        verify(userRepository).saveUserScore(33, 1);

    }

    @Test
    void calculateUserScore() {
    }

    @Test
    void listAllInactiveUsers() {
    }

    @Test
    void testCalculateUserScore() {
    }
}