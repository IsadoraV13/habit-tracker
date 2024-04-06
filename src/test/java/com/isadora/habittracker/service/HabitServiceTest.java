package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.Theme;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.HabitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class HabitServiceTest {
    private HabitService habitService;
    @Mock
    private HabitRepository habitRepository;
    @Mock
    private RewardService rewardService;
    @Mock
    private UserService userService;
    private User testUser;
    private Reward testReward;
    private Theme testTheme;


    @BeforeEach
    void setUp() {
        habitService = new HabitService(habitRepository, rewardService, userService);

        testUser = new User();
        testUser.setUsername("new gal");
        testUser.setActive(true);
        testUser.setId(3);

        testReward = new Reward();
        testReward.setId(1);
        testReward.setRewardName("L1");

        testTheme = new Theme();
        testTheme.setId(2);
    }

    @Test
    void createNewHabit() {
        Habit expectedHabit = new Habit();
        expectedHabit.setHabitName("new habit");
        expectedHabit.setUser(testUser);
        expectedHabit.setReward(testReward);
        expectedHabit.setThemeId(testTheme.getId());
        expectedHabit.setStreakFrequency("weekly");
        expectedHabit.setCounter(0);
        expectedHabit.setDifficultyPoints(4);

        Mockito.when(rewardService.listRewardById(1)).thenReturn(Optional.ofNullable(testReward));
        Mockito.when(habitRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        Habit actualHabit = habitService.createNewHabit(
                testUser, "new habit", 2, "weekly", 4);

        assertThat(actualHabit).isEqualTo(expectedHabit);

    }

    @Test
    void updateHabit() {
    }
}