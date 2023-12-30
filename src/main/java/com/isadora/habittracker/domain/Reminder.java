package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
public class Reminder {
    private int reminderId;
    private int habitId; //every reminder is linked to a habit
    private Timestamp startTime;

    public Reminder(int reminderId, int habitId, Timestamp startTime) {
        this.reminderId = reminderId;
        this.habitId = habitId;
        this.startTime = startTime;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
