package com.isadora.habittracker.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="habit")
public class Habit {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private String habitName; // user defined ToDo: later add a field 'habit details'
    private int userId;
    @ManyToOne
    @JoinColumn(name="reward_id")
    private Reward reward;
    private int themeId;
    private int difficultyPoints; //ToDo translate this from an Enum selected by the user (Hard, Medium, Easy)
    private Timestamp created;
    private Timestamp lastModified;

    //ToDo need a way to determine streaks

    // when user clicks a button to confirm they have performed a habit:
        // reward.save()
        // create a streak of 0 (for first time)
        // then create rules (where?) around how often the habit must/can be performed to determine if a streak is achieved

    public Habit() {

    }

    public int getId() {
        return id;
    }

    public void setId(int habitId) {
        this.id = habitId;
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

    public Reward getReward() {
        return reward;
    }

    public int getThemeId() {
        return themeId;
    }

    public int getDifficultyPoints() {
        return difficultyPoints;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

}
