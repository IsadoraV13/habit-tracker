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

    public void assignRewardWhenSavingHabit(Habit newHabit, Reward rewardLevel) {
        newHabit.setReward(rewardLevel);
        rewardLevel.getHabits().add(newHabit);
    }

    public Habit saveHabit(Habit newHabit) {
        return habitRepository.save(newHabit);
    }
}
