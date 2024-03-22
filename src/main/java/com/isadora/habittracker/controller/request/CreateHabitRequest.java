package com.isadora.habittracker.controller.request;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Theme;

public record CreateHabitRequest(String habitName, int difficultyPoints) {
    public static CreateHabitRequest of(Habit habit) {
        return new CreateHabitRequest(habit.getHabitName(), habit.getDifficultyPoints());
    }

}
