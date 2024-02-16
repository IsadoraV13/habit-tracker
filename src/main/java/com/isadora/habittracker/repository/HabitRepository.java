package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.Habit;
import org.springframework.data.repository.CrudRepository;


public interface HabitRepository extends CrudRepository <Habit, Integer> {
}
