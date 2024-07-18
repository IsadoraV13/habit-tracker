package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.Reward;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.repository.HabitRepository;
import com.isadora.habittracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final RewardService rewardService;
    private final UserService userService;
    private final UserRepository userRepository;

    public HabitService(final HabitRepository habitRepository, RewardService rewardService, UserService userService, UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.rewardService = rewardService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<Habit> listAllHabits() {
        return StreamSupport.stream(habitRepository.findAll().spliterator(), false).toList();
    }

    public Optional<Habit> listHabitById(int habitId) {
        return habitRepository.findById(habitId);
    }

    private void assignDefaultRewardWhenSavingHabit(Habit newHabit) {
        Reward defaultReward = rewardService.listRewardById(1).get();
        newHabit.setReward(defaultReward);

    }

    public Habit createNewHabit(final User loggedInUser, final String habitName, final int themeId, final String streakFrequency,
                                final int difficultyPoints) {
        Habit newHabit = new Habit();
        newHabit.setHabitName(habitName);
        newHabit.setUser(loggedInUser);
        newHabit.setThemeId(themeId);
        newHabit.setStreakFrequency(streakFrequency);
        newHabit.setCounter(0);
        newHabit.setDifficultyPoints(difficultyPoints);
        assignDefaultRewardWhenSavingHabit(newHabit);
        return habitRepository.save(newHabit);
    }


    public Habit userInitiatedHabitUpdate(final int habitId, final String habitName, final int themeId,
                                          final String streakFrequency, final int difficultyPoints) {
        Optional<Habit> habitToUpdate = listHabitById(habitId);
        if (habitToUpdate.isPresent()) {
            habitToUpdate.get().setHabitName(habitName);
            habitToUpdate.get().setThemeId(themeId);
            habitToUpdate.get().setStreakFrequency(streakFrequency);
            habitToUpdate.get().setDifficultyPoints(difficultyPoints);
            return habitRepository.save(habitToUpdate.get());
        }
        throw new EntityNotFound();
    }

    // this is triggered when a user completes a habit (score goes up and reward level may go up)
    public Habit systemInitiatedHabitUpdate(User loggedInUser, Habit habitToUpdate) {
        // this would be called when a user performs a habit, therefore:
        // the (habit) counter changes
        // the (user) score is updated - based on difficultyPoints and streakFrequency
        // they might be moved to the next reward level (based on their level of progress)

        // get current stats
        int rewardId = habitToUpdate.getReward().getId();
        String frequency = habitToUpdate.getStreakFrequency();

        // get current counter
        int counter = habitToUpdate.getCounter();

        // below only covers Iteration1 (Reward Level 1 & 2)
        //ToDo: update rules for changing Reward from L2 onwards
        int updatedRewardId = updateRewardId(rewardId, frequency, counter); // ToDo ask Noe: is it best to pass values here (vs passing a habit again?

        var updatedReward = rewardService.listRewardById(updatedRewardId);
        if (updatedReward.isEmpty()) {
            throw new EntityNotFound();
        }
        habitToUpdate.setReward(updatedReward.get());
        habitToUpdate.setCounter(counter + 1);

//        userService.updateUserScore(newScore, loggedInUser.getId());

        Habit updatedHabit = null;
        try {
            updatedHabit = habitRepository.save(habitToUpdate);
        } catch (Exception e) {
        }

        // calculate and update score based on current stats
        // loggedInUser already verified in habit controller before passing to this service
        int newScore = userService.calculateUserScore(loggedInUser, habitToUpdate);
        loggedInUser.setScore(newScore);
        try {
            userRepository.saveUserScore(newScore, loggedInUser.getId());
        } catch (Exception e) {
        }

        return updatedHabit;
        // ToDo check with Noe: is this the right way to handle the fact that save() might return an exception?


    }

    protected int updateRewardId(int rewardId, String frequency, int counter) {
        //ToDo: update rules for changing Reward from L2 onwards
        if (rewardId == 1) {
            rewardId += 1;

        } else if (rewardId == 2) {
            if (counter == 15 & frequency.equals("daily")) {
                rewardId += 1;
            } else if (counter == 4 & frequency.equals("weekly")) {
                rewardId += 1;
            }
        }

        return rewardId;

    }
}
