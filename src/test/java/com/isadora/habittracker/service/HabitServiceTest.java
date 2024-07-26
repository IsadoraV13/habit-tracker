package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.Theme;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.HabitRepository;
import com.isadora.habittracker.repository.UserRepository;
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
    @Mock
    private UserRepository userRepository;
    private User testUser;
    private Habit testHabit;
    private Reward testReward1;
    private Reward testReward2;
    private Theme testTheme;
    private String habitName = "new habit";
    private String weekly = "weekly";
    private String daily = "daily";

    @BeforeEach
    void setUp() {
        habitService = new HabitService(habitRepository, rewardService, userService, userRepository);

        testUser = new User();
        testUser.setUsername("new gal");
        testUser.setActive(true);
        testUser.setId(3);

        testReward1 = new Reward();
        testReward1.setId(1);
        testReward1.setRewardName("L1");

        testReward2 = new Reward();
        testReward2.setId(1);
        testReward2.setRewardName("L1");

        testHabit = new Habit();
        testHabit.setHabitName(habitName);
        testHabit.setUser(testUser);
        testHabit.setReward(testReward1);
        testHabit.setThemeId(2);
        testHabit.setStreakFrequency(weekly);
        testHabit.setCounter(0);
        testHabit.setDifficultyPoints(4);

//        testTheme = new Theme();
//        testTheme.setId(2);
    }

    @Test
    void createNewHabitTest() {
        // Given -> testHabit
        Mockito.when(rewardService.listRewardById(1)).thenReturn(Optional.ofNullable(testReward1));
        Mockito.when(habitRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        // When -> createNewHabit()
        Habit savedHabit = habitService.createNewHabit(
                testUser, habitName, 2, weekly, 4);

        // ToDo: check with Noe: why does actualHabit not have timestamps or id?
        System.out.println("savedHabit: " + savedHabit);
        System.out.println("testHabit: " + testHabit);
        // Then
        assertThat(savedHabit).isEqualTo(testHabit);

    }

    @Test
    void systemInitiatedHabitUpdateTest() {
        // Given -> testHabit
        testHabit.setCounter(0);

        int newScore = 5;
        Mockito.when(userService.calculateUserScore(testUser, testHabit)).thenReturn(newScore);
        Mockito.when(rewardService.listRewardById(2)).thenReturn(Optional.of(testReward2));
        Mockito.when(habitRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        // When -> systemInitiatedHabitUpdate()
        Habit savedHabit = habitService.systemInitiatedHabitUpdate(testUser, testHabit);

        System.out.println("savedHabit: " + savedHabit);
        System.out.println("testHabit: " + testHabit);

        // Then
        assertThat(savedHabit).isEqualTo(testHabit);

    }
    @Test
    void systemInitiatedHabitUpdateTestwithError() {
        // Given -> testHabit
        testHabit.setCounter(0);

        int newScore = 5;
        Mockito.when(userService.calculateUserScore(testUser, testHabit)).thenReturn(newScore);
        Mockito.when(rewardService.listRewardById(2)).thenReturn(Optional.of(testReward2));
        Mockito.when(habitRepository.save(any())).thenReturn(new Exception());

        // When -> systemInitiatedHabitUpdate()
        Habit updatedHabit = habitService.systemInitiatedHabitUpdate(testUser, testHabit);

        System.out.println("updatedHabit: " + updatedHabit);
        System.out.println("testHabit: " + testHabit);

        // Then
        assertThat(updatedHabit).isNull();

    }

    @Test
    void userInitiatedHabitUpdate() {
        // Given -> testHabit
        testHabit.setId(1);
        testHabit.setCounter(0);

        Mockito.when(habitRepository.findById(1)).thenReturn(Optional.ofNullable(testHabit));
        Mockito.when(habitRepository.save(any())).then(AdditionalAnswers.returnsFirstArg());

        // When -> userInitiatedHabitUpdate()
        // change themeId from 2 to 3
        // change weekly to daily
        // change diffPoint from 4 to 3
        Habit savedHabit = habitService.userInitiatedHabitUpdate(1,habitName, 3, daily, 3);

        System.out.println("savedHabit: " + savedHabit);
        System.out.println("testHabit: " + testHabit);

        // Then
        assertThat(savedHabit).isEqualTo(testHabit);
    }
}