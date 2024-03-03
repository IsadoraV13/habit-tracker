package com.isadora.habittracker.domain;

/* This is an example */
public record HabitResponse(int habitId, String habitName, int points) {

    public static HabitResponse of(Habit habit) {
        return new HabitResponse(habit.getHabitId(), habit.getHabitName(), habit.getPoints());
    }

}
