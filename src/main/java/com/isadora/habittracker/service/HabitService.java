package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.HabitResponse;
import com.isadora.habittracker.repository.HabitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> listAllHabits() {
        return StreamSupport.stream(habitRepository.findAll().spliterator(), false).toList();
    }

    public Optional<Habit> listHabitById(int habitId) {
        return habitRepository.findById(habitId);
    }
}
