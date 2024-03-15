package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "reminder")
public class Reminder {

    @Id
    private int reminderId;
    private int habitId; //every reminder is linked to a habit
    private Timestamp startTime;

    public Reminder(int reminderId, int habitId, Timestamp startTime) {
        this.reminderId = reminderId;
        this.habitId = habitId;
        this.startTime = startTime;
    }

    public Reminder() {

    }

    public int getReminderId() {
        return reminderId;
    }

    public int getHabitId() {
        return habitId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

}
