package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.repository.RewardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RewardService {

    private final RewardRepository rewardRepository;

    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public Optional<Reward> listRewardById(int rewardId) {
        return rewardRepository.findById(rewardId);
    }
}
