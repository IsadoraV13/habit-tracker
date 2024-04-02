package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.Theme;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.HabitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class HabitServiceTest {

    private HabitService habitService;
    @MockBean
    private HabitRepository habitRepository;
    @MockBean
    private RewardService rewardService;
    @MockBean
    private UserService userService;
    private User testUser;
    private Reward testReward;
    private Theme testTheme;


    @BeforeEach
    void setUp() {
        habitService = new HabitService(habitRepository, rewardService, userService);


    }

//    @Test
//    void createNewHabit() {
//        testUser.setUsername("new gal");
//        testUser.setActive(true);
//        testUser.setId(3);
//        testReward.setId(1);
//        testReward.setRewardName("L1");
//        testTheme.setId(2);
//        Habit expectedHabit = new Habit();
//        expectedHabit.setHabitName("new habit");
//        expectedHabit.setUser(testUser);
//        expectedHabit.setReward(testReward);
//        expectedHabit.setThemeId(testTheme.getId());
//        expectedHabit.setDifficultyPoints(4);
//
//        Mockito.when(RewardService.listRewardById(1)).thenReturn(testReward);
//        habitService.assignDefaultRewardWhenSavingHabit(expectedHabit);
//        assertThat(expectedHabit).isEqualTo(habitService.createNewHabit(
//                3, "new habit", 2, 4));
//
//    }

    @Test
    void updateHabit() {
    }
}