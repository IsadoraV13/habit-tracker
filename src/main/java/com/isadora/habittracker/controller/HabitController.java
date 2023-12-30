package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.Habit;
import com.isadora.habittracker.domain.ResponseObject;
import com.isadora.habittracker.service.HabitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/habit")
public class HabitController {

    final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping("/{habitId}")
    public ResponseObject<List<Habit>> ViewAllHabits(int habitId) {
        ResponseObject<List<Habit>> res = new ResponseObject();
        res.setData(habitService.listAllHabits());
        return res;
    }


}
