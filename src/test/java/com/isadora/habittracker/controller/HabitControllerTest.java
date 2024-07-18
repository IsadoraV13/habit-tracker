package com.isadora.habittracker.controller;

import com.isadora.habittracker.service.HabitService;
import com.isadora.habittracker.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HabitController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class HabitControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private HabitController habitController;
    @Mock
    private HabitService habitService;
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void viewAllHabits() {
    }

    @Test
    void viewAllHabitsTest() {
    }

    @Test
    void viewHabitById() {
    }

    @Test
    void createHabit() {
//        given(habitService.createNewHabit());
    }

    @Test
    void userHabitUpdate() {
    }

    @Test
    void systemHabitUpdate() {
    }
}