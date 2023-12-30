package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;

@Entity
public class Reward {
    private int rewardId;

    private String rewardName;
    private int habitId; //a reward is linked to a specific habit

    public Reward(int rewardId, String rewardName, int habitId) {
        this.rewardId = rewardId;
        this.rewardName = rewardName;
        this.habitId = habitId;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }
}
