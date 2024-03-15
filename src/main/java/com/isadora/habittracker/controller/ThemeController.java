package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.*;
import com.isadora.habittracker.service.RewardService;
import com.isadora.habittracker.service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(final ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping()
    public Iterable<Theme> viewAllThemes() {
        return themeService.listAllThemes();
    }

    @GetMapping("/{themeId}")
    public ResponseEntity<ThemeResponse> viewThemeById(@PathVariable int themeId) {
        var someTheme =  themeService.listThemeById(themeId);
        if (someTheme.isPresent()) {
            return ResponseEntity.ok(ThemeResponse.of(someTheme.get()));
        }
        throw new EntityNotFound();
    }
}
