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
    void createNewHabitTest() {
        // Given
        String habitName = "new habit";
        String frequency = "weekly";
        Habit expectedHabit = new Habit();
        expectedHabit.setHabitName(habitName);
        expectedHabit.setUser(testUser);
        expectedHabit.setReward(testReward);
        expectedHabit.setThemeId(testTheme.getId());
        expectedHabit.setStreakFrequency(frequency);
        expectedHabit.setCounter(0);
        expectedHabit.setDifficultyPoints(4);

        Mockito.when(rewardService.listRewardById(1)).thenReturn(Optional.ofNullable(testReward));
        Mockito.when(habitRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        // When
        Habit actualHabit = habitService.createNewHabit(
                testUser, habitName, 2, frequency, 4);

        // Then
        assertThat(actualHabit).isEqualTo(expectedHabit);

    }

    @Test
    void systemInitiatedHabitUpdateTest() {
        // Given
        // reward setup
        Reward reward1 = new Reward();
        reward1.setId(1);

        Reward reward2 = new Reward();
        reward2.setId(1);

        // habitToUpdate setup
        Habit habitToUpdate = new Habit();
        habitToUpdate.setId(2);
        habitToUpdate.setReward(reward1);
        habitToUpdate.setStreakFrequency("daily");
        habitToUpdate.setCounter(0);

        // savedHabit setup
        Habit savedHabit = new Habit();
        savedHabit.setId(2);
        savedHabit.setReward(reward1);
        savedHabit.setStreakFrequency("daily");
        savedHabit.setCounter(0);

        // user setup
        User user = new User();
        user.setId(1);
        user.setScore(0);

        int newscore = 5;
        Mockito.when(userService.calculateUserScore(user, habitToUpdate)).thenReturn(5);
//        Mockito.when(habitService.updateRewardId(habit.getReward().getId(), habit.getStreakFrequency(), habit.getCounter()));
        Mockito.when(rewardService.listRewardById(2)).thenReturn(Optional.of(reward2));
        Mockito.when(habitRepository.save(habitToUpdate)).thenReturn(savedHabit);

        // Then
//        assertThat(actualHabit).isEqualTo(expectedHabit);

    }
}