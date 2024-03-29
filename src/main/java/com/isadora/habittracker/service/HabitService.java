package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Reward;
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

    public Habit assignDefaultRewardWhenSavingHabit(Habit newHabit) {
        Reward defaultReward = rewardService.listRewardById(1).get();
        newHabit.setReward(defaultReward);
        return habitRepository.save(newHabit);

    }

    public Habit createNewHabit(final int userId, final String habitName, final int themeId, final int difficultyPoints) {
        Habit newHabit = new Habit();
        newHabit.setHabitName(habitName);
        newHabit.setUser(userService.listUserById(userId).get());
        newHabit.setReward(rewardService.listRewardById(1).get());
        newHabit.setThemeId(themeId);
        newHabit.setDifficultyPoints(difficultyPoints);
        assignDefaultRewardWhenSavingHabit(newHabit);
        return habitRepository.save(newHabit);
    }


    public Habit updateHabit(final int userId, final int habitId, final String habitName, final int themeId, final int difficultyPoints) {
        Optional<Habit> habitToUpdate = listHabitById(habitId);
        if (habitToUpdate.isPresent()) {
            habitToUpdate.get().setHabitName(habitName);
            habitToUpdate.get().setUser(userService.listUserById(userId).get());
            habitToUpdate.get().setReward(rewardService.listRewardById(1).get());
            habitToUpdate.get().setThemeId(themeId);
            habitToUpdate.get().setDifficultyPoints(difficultyPoints);
            assignDefaultRewardWhenSavingHabit(habitToUpdate.get());
            return habitRepository.save(habitToUpdate.get());
        }
        throw new EntityNotFound();
    }
}
