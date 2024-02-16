package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitService {

    final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Iterable<Habit> listAllHabits() {
        return habitRepository.findAll();

    }

    public Optional<Habit> listHabitById(int habitId) {
        return habitRepository.findById(habitId);
    }
}
