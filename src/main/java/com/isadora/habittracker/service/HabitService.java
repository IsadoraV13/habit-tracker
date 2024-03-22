package com.isadora.habittracker.service;

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

    public HabitService(final HabitRepository habitRepository, RewardService rewardService) {
        this.habitRepository = habitRepository;
        this.rewardService = rewardService;
    }

    public List<Habit> listAllHabits() {
        return StreamSupport.stream(habitRepository.findAll().spliterator(), false).toList();
    }

    public Optional<Habit> listHabitById(int habitId) {
        return habitRepository.findById(habitId);
    }

    public Habit assignDefaultRewardWhenSavingHabit(Habit newHabit) {
        Reward defaultReward = rewardService.listRewardById(1).get(); // ToDo is this okay?
        newHabit.setReward(defaultReward);
        return habitRepository.save(newHabit);

    }

    public Habit createNewHabit(final long userId, final String habitName, final int themeId, final int difficultyPoints) {
        Habit newHabit = new Habit();
        newHabit.setId(userId);
        newHabit.setHabitName(habitName);
        newHabit.setReward(rewardService.listRewardById(1).get());
        newHabit.setThemeId(themeId);
        newHabit.setDifficultyPoints(difficultyPoints);
        assignDefaultRewardWhenSavingHabit(newHabit);
        return habitRepository.save(newHabit);
    }
}
