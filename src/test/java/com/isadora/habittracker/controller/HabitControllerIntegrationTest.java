package com.isadora.habittracker.controller;

import com.isadora.habittracker.service.HabitService;
import com.isadora.habittracker.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HabitControllerIntegrationTest {
    private MockMvc mockMvc;
    private final HabitService habitService;
    private final UserService userService;

    HabitControllerIntegrationTest(HabitService habitService, UserService userService) {
        this.habitService = habitService;
        this.userService = userService;
    }

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

    }

    @ValueSource(ints = {1,2})
    void shouldReturnOk(int userId, int themeId) throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.post("/habits//{userId}/{themeId}/new")
                        .param("userId", String.valueOf(userId))
                        .param("themeId", String.valueOf(themeId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void userHabitUpdate() {
    }

    @Test
    void systemHabitUpdate() {
    }
}