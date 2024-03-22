package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.controller.response.RewardResponse;
import com.isadora.habittracker.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(final RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping()
    public Iterable<Reward> viewAllRewards() {
        return rewardService.listAllRewards();
    }

    @GetMapping("/{rewardId}")
    public ResponseEntity<RewardResponse> viewRewardById(@PathVariable int rewardId) {
        var someReward =  rewardService.listRewardById(rewardId);
        if (someReward.isPresent()) {
            return ResponseEntity.ok(RewardResponse.of(someReward.get()));
        }
        throw new EntityNotFound();
    }
}
