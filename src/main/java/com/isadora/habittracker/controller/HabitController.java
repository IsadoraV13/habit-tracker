package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.HabitNotFound;
import com.isadora.habittracker.domain.HabitResponse;
import com.isadora.habittracker.service.HabitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<ResponseEntity<HabitResponse>> ViewAllHabits() {
        final List<Habit> allHabits = habitService.listAllHabits();
        if (!allHabits.isEmpty()) {
            return allHabits.stream().map(habit -> ResponseEntity.ok(HabitResponse.of(habit))).toList();
        }
        //StreamSupport.stream(allHabits.spliterator(), false)
        throw new HabitNotFound();
    }

    @GetMapping("/test/{habitId}")
    // ToDo ????
    public ResponseEntity<HabitResponse> ViewHabitById(@PathVariable int habitId) {
        final var someHabit = habitService.listHabitById(habitId);
        if (someHabit.isPresent()) {
            return ResponseEntity.ok(HabitResponse.of(someHabit.get()));
        }
//        return ResponseEntity.notFound().build();
        throw new HabitNotFound();
    }

    // Optional int parameter 'habitId' is present but cannot be translated into a null value due to being declared as
    // a primitive type. Consider declaring it as object wrapper for the corresponding primitive type.

}
