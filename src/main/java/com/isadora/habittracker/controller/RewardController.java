package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/{rewardId}")
    public Optional<Reward> viewRewardById(@PathVariable int rewardId) {
        return rewardService.listRewardById(rewardId);

    }

    @GetMapping()
    public Iterable<Reward> viewAllRewards() {
        return rewardService.listAllRewards();

    }
}
