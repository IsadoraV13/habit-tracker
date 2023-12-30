package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Habit {
    @Id
    @GeneratedValue
    private int habitId;
    private String habitName; // user defined
    private int userId;
    private int themeId;
    private int points;
    private Timestamp created;
    private Timestamp lastModified;

    //ToDo need a way to determine streaks


    public Habit(int habitId, String habitName, int userId, int themeId, int points, Timestamp created, Timestamp lastModified) {
        this.habitId = habitId;
        this.habitName = habitName;
        this.userId = userId;
        this.themeId = themeId;
        this.points = points;
        this.created = created;
        this.lastModified = lastModified;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }
}
