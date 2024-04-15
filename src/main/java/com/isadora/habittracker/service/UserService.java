package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final HabitService habitService;

    public UserService(final UserRepository userRepository, HabitService habitService) {
        this.userRepository = userRepository;
        this.habitService = habitService;
    }

    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    public List<User> listAllActiveUsers() {
        return userRepository.findAllActiveUsers();
    }

    public Optional<User> listUserById(int userId) {
        return userRepository.findById(userId);
    }

    public List<User> listAllInactiveUsers() {
        return userRepository.findAllInactiveUsers();
    }

//    @Transactional
    public void updateUserScore(int score, int userId) {
        userRepository.saveUserScore(score, userId);
    }

    // when habit performed (pass HabitId),
    // if counter=0 and Reward=L1, then it's a first time habit. -> Calculate score
    // if counter=0 and Reward=L2, then it's not a first time habit. -> Calculate score
    public int calculateUserScore(User loggedInUser, int habitId) {

        int score = loggedInUser.getScore();
//        var habit = habitService.listHabitById(habitId);
//        if (habit.isPresent()) {
//            rewardId = habit.get().getReward().getId();
//
//        }
        if (habitService.listHabitById(habitId).isEmpty()) {
            throw new EntityNotFound();
        }

        Habit habit = habitService.listHabitById(habitId).get();
        int rewardId = habit.getReward().getId();
        int difficultyPoints = habit.getDifficultyPoints();
        int counter = habit.getCounter();

        // if first time habit performed
        if (counter == 0 && rewardId == 1) {
            switch (difficultyPoints) {
                case 1:
                    score += 2;
                    break;
                case 2:
                    score += 3;
                    break;
                case 3:
                    score += 5;
                    break;
            }

        } else if (counter == 0 && rewardId == 2) {
            switch (difficultyPoints) {
//                case 1:
//                    score += 0;
//                    break;
                case 2:
                    score += 3;
                    break;
                case 3:
                    score += 5;
                    break;
            }
        }
        return score;
    }
}
