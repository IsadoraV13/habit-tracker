package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.HabitResponse;
import com.isadora.habittracker.service.HabitService;
import com.isadora.habittracker.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;
    private final RewardService rewardService;

    public HabitController(final HabitService habitService, RewardService rewardService) {
        this.habitService = habitService;
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<ResponseEntity<HabitResponse>> ViewAllHabits() {
        final List<Habit> allHabits = habitService.listAllHabits();
        if (!allHabits.isEmpty()) {
            return allHabits.stream().map(habit -> ResponseEntity.ok(HabitResponse.of(habit))).toList();
        }
        //StreamSupport.stream(allHabits.spliterator(), false)
        throw new EntityNotFound();
    }
    @GetMapping("/test")
    public Iterable<Habit> viewAllHabitsTest() {
        return habitService.listAllHabits();
    }

    @GetMapping("/{habitId}")
    public ResponseEntity<HabitResponse> ViewHabitById(@PathVariable int habitId) {
        final var someHabit = habitService.listHabitById(habitId);
        if (someHabit.isPresent()) {
            return ResponseEntity.ok(HabitResponse.of(someHabit.get()));
        }
//        return ResponseEntity.notFound().build();
        throw new EntityNotFound();
    }

    // Optional int parameter 'habitId' is present but cannot be translated into a null value due to being declared as
    // a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.

    @PostMapping("/new")
    public ResponseEntity<Habit> saveHabit(@RequestBody Habit newHabit) {
        return ResponseEntity.ok(habitService.saveHabit(newHabit));
//        habitService.saveHabit(newHabit);
//        habitService.assignRewardWhenSavingHabit(newHabit, rewardService.listRewardById(1).get());
//        return ResponseEntity.ok(habitService.listHabitById(newHabit.getId()).get());
    }

    /* Habit saved via postman - without reward
        {
            "habitName": "new habit via postman - without reward",
            "userId": 1,
            "themeId":1,
            "difficultyPoints": 3
        }
     */
}
