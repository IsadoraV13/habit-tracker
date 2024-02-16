package com.isadora.habittracker.controller;

//import com.isadora.habittracker.service.RewardService;

import com.isadora.habittracker.service.RewardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

//    @GetMapping("/{rewardId")
//    public Optional<Reward> viewRewardById(int rewardId) {
//        return rewardService.listRewardById(rewardId);
//
//    }
}
