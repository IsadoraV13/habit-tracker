package com.isadora.habittracker.controller.response;

import com.isadora.habittracker.domain.Reward;

public record RewardResponse(int rewardId, String rewardName) {

    public static RewardResponse of(Reward reward) {
        return new RewardResponse(reward.getId(), reward.getRewardName());
    }

}
