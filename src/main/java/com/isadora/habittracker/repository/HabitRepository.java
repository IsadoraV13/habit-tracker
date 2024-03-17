package com.isadora.habittracker.repository;

import com.isadora.habittracker.domain.Habit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends CrudRepository <Habit, Integer> {

}
