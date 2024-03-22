package com.isadora.habittracker.controller.request;

import com.isadora.habittracker.domain.Theme;

public record CreateThemeRequest(String themeName) {
    public static CreateThemeRequest of(Theme theme) {
        return new CreateThemeRequest(theme.getThemeName());
    }

}
