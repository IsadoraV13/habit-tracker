package com.isadora.habittracker.domain;

import java.util.Set;

public record RewardResponse(int rewardId, String rewardName, Set<Habit> habits) {

    public static RewardResponse of(Reward reward) {
        return new RewardResponse(reward.getId(), reward.getRewardName(), reward.getHabits());
    }

}
