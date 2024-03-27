package com.isadora.habittracker.controller;

import com.isadora.habittracker.controller.response.ThemeResponse;
import com.isadora.habittracker.domain.*;
import com.isadora.habittracker.service.ThemeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    private final RestTemplate restTemplate;

    public ThemeController(final ThemeService themeService, RestTemplate restTemplate) {
        this.themeService = themeService;
        this.restTemplate = restTemplate;
    }

    @GetMapping()
    public Iterable<Theme> viewAllThemes() {
        return themeService.listAllThemes();
    }

//    @GetMapping("/users/{userId}")
//    public ResponseEntity<Theme[]> viewThemeByUserId(@PathVariable int userId) {
//        var someThemes = themeService.listThemeByUserId(userId);
//        ResponseEntity<Theme[]> response =
//                restTemplate.getForEntity(
//                        String.format("http://localhost:8086/themes/users/%s", userId),
//                        Theme[].class, someThemes);
//        return ResponseEntity.ok(response.getBody()); //ToDo how to set ResponseEntity with a list of Response Objects?
//
//    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ThemeResponse>> viewThemeByUserId(@PathVariable int userId) {
        var someThemes = themeService.listThemeByUserId(userId);
        if (StreamSupport.stream(someThemes.spliterator(), false).findAny().isPresent()) {
            var themeResponseList = StreamSupport.stream(someThemes.spliterator(), false).collect(Collectors.toList())
                    .stream().map(s -> ThemeResponse.of(s)).collect(Collectors.toList());
            return ResponseEntity.ok(themeResponseList);
        }
        throw new EntityNotFound();



//        ResponseEntity<ThemeResponse[]> response =
//                restTemplate.getForEntity(
//                        String.format("http://localhost:8086/themes/users"),
//                        ThemeResponse[].class, someThemes);
//        return ResponseEntity.ok(response.getBody()); //ToDo how to set ResponseEntity with a list of Response Objects?
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
