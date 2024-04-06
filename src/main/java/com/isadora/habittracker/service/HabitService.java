package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final RewardService rewardService;
    private final UserService userService;

    public HabitService(final HabitRepository habitRepository, RewardService rewardService, UserService userService) {
        this.habitRepository = habitRepository;
        this.rewardService = rewardService;
        this.userService = userService;
    }

    public List<Habit> listAllHabits() {
        return StreamSupport.stream(habitRepository.findAll().spliterator(), false).toList();
    }

    public Optional<Habit> listHabitById(int habitId) {
        return habitRepository.findById(habitId);
    }

    private void assignDefaultRewardWhenSavingHabit(Habit newHabit) {
        Reward defaultReward = rewardService.listRewardById(1).get();
        newHabit.setReward(defaultReward);

    }

    public Habit createNewHabit(final User loggedInUser, final String habitName, final int themeId, final String streakFrequency,
                                final int difficultyPoints) {
        Habit newHabit = new Habit();
        newHabit.setHabitName(habitName);
        newHabit.setUser(loggedInUser);
        newHabit.setThemeId(themeId);
        newHabit.setStreakFrequency(streakFrequency);
        newHabit.setCounter(0);
        newHabit.setDifficultyPoints(difficultyPoints);
        assignDefaultRewardWhenSavingHabit(newHabit);
        return habitRepository.save(newHabit);
    }


    public Habit userInitiatedHabitUpdate(final int habitId, final String habitName, final int themeId,
                                          final String streakFrequency, final int difficultyPoints) {
        Optional<Habit> habitToUpdate = listHabitById(habitId);
        if (habitToUpdate.isPresent()) {
            habitToUpdate.get().setHabitName(habitName);
            habitToUpdate.get().setThemeId(themeId);
            habitToUpdate.get().setStreakFrequency(streakFrequency);
            habitToUpdate.get().setDifficultyPoints(difficultyPoints);
            return habitRepository.save(habitToUpdate.get());
        }
        throw new EntityNotFound();
    }

    public Habit systemInitiatedHabitUpdate(final int habitId, final int rewardId, final int counter) {
        Optional<Habit> habitToUpdate = listHabitById(habitId);
        if (habitToUpdate.isPresent()) {
            habitToUpdate.get().setReward(rewardService.listRewardById(rewardId).get());
            habitToUpdate.get().setCounter(counter);
            return habitRepository.save(habitToUpdate.get());
        }
        throw new EntityNotFound();
    }
}
