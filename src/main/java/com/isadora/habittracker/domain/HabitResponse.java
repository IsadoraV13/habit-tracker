package com.isadora.habittracker.domain;

/* This is an example */
public record HabitResponse(int habitId, String habitName, int difficultyPoints) {

    public static HabitResponse of(Habit habit) {
        return new HabitResponse(habit.getId(), habit.getHabitName(), habit.getDifficultyPoints());
    }

}
