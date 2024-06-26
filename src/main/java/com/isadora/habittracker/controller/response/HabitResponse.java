package com.isadora.habittracker.controller.response;

import com.isadora.habittracker.domain.Habit;

/* This is an example */
public record HabitResponse(long habitId, String habitName, String streakFrequency, int counter, int difficultyPoints) {

    public static HabitResponse of(Habit habit) {
        return new HabitResponse(habit.getId(), habit.getHabitName(), habit.getStreakFrequency(), habit.getCounter(),
                habit.getDifficultyPoints());
    }

}
