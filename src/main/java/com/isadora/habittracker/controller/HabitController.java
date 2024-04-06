package com.isadora.habittracker.controller;

import com.isadora.habittracker.controller.request.CreateHabitRequest;
import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.controller.response.HabitResponse;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.service.HabitService;
import com.isadora.habittracker.service.RewardService;
import com.isadora.habittracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;
    private final RewardService rewardService;

    private final UserService userService;

    public HabitController(final HabitService habitService, RewardService rewardService, UserService userService) {
        this.habitService = habitService;
        this.rewardService = rewardService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<HabitResponse>> ViewAllHabits() {
        var allHabits = habitService.listAllHabits();
        if (!allHabits.isEmpty()) {
            var habitResponseList = StreamSupport.stream(allHabits.spliterator(), false).collect(Collectors.toList())
                    .stream().map(s -> HabitResponse.of(s)).collect(Collectors.toList());
            return ResponseEntity.ok(habitResponseList);
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


    // click create new habit
    // 'Select the Theme this is linked to" >> Theme drop down (findThemesByUserId)
    // ToDo/Question: once a Theme is selected, is the ThemeId passed into the url for the Habit post url

    @PostMapping("/{userId}/{themeId}/new")
    public ResponseEntity<Habit> createHabit(@RequestBody CreateHabitRequest createHabitRequest,
                                             @PathVariable(name = "userId") int userId,
                                             @PathVariable(name = "themeId") int themeId) { // CreateHabitRequest (name, userId,...)
//        habitService.saveHabit(name, userId, ...)

        //get user from userService here and pass user to HabitService
        User loggedInUser = userService.listUserById(userId).get();

        return ResponseEntity.ok(habitService.createNewHabit(loggedInUser, createHabitRequest.habitName(), themeId,
                createHabitRequest.streakFrequency(), createHabitRequest.difficultyPoints()));
        // here: needs to take the assignDefault method
//        habitService.assignRewardWhenSavingHabit(newHabit, rewardService.listRewardById(1).get());

    }

    /* Habit saved via postman - without reward
        {
            "habitName": "new habit via postman - without reward",
            "streakFrequency": "weekly",
            "difficultyPoints": 3
        }
     */

    @PutMapping("/user-update/{habitId}")
    public ResponseEntity<Habit> userHabitUpdate(@RequestBody CreateHabitRequest createHabitRequest,
                                             @PathVariable(name = "habitId") int habitId) {

        return ResponseEntity.ok(habitService.userInitiatedHabitUpdate(habitId, createHabitRequest.habitName(),
                createHabitRequest.themeId(), createHabitRequest.streakFrequency(), createHabitRequest.difficultyPoints()));

    }

    @PutMapping("/update/{habitId}/{rewardId}/{counter}")
    public ResponseEntity<Habit> systemHabitUpdate(@PathVariable(name = "habitId") int habitId,
                                                   @PathVariable(name = "rewardId") int rewardId,
                                                   @PathVariable(name = "counter") int counter) {

        return ResponseEntity.ok(habitService.systemInitiatedHabitUpdate(habitId, rewardId, counter));

    }


}
