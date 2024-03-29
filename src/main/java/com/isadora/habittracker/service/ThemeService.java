package com.isadora.habittracker.service;

import com.isadora.habittracker.domain.Theme;
import com.isadora.habittracker.repository.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    public ThemeService(final ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public Optional<Theme> listThemeById(int themeId) {
        return themeRepository.findById(themeId);
    }

    public Iterable<Theme> listAllThemes() {
        return themeRepository.findAll();
    }

    public Iterable<Theme> listThemeByUserId(int userId) {
        return themeRepository.findByUserId(userId);
    }

    public Iterable<Theme> listThemeByUsers() {
        return themeRepository.findThemesAndUsers();
    }
}
