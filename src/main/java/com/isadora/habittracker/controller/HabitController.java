package com.isadora.habittracker.controller;

import com.isadora.habittracker.service.HabitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habit")
public class HabitController {

    final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

//    @GetMapping
//    public ResponseObject<List<Habit>> ViewAllHabits() {
//        ResponseObject<List<Habit>> res = new ResponseObject();
//        res.setData(habitService.listAllHabits());
//        return res;
//    }
//
//    @GetMapping("/{habitId}")
//    public ResponseObject<Optional<Habit>> ViewHabitById(int habitId) {
//        ResponseObject<Optional<Habit>> res = new ResponseObject();
//        res.setData(habitService.listHabitById(habitId));
//        return res;
//    }


}
