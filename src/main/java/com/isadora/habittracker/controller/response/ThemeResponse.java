package com.isadora.habittracker.controller.response;

import com.isadora.habittracker.domain.Theme;

public record ThemeResponse(int themeId, String themeName) {

    public static ThemeResponse of(Theme theme) {
        return new ThemeResponse(theme.getId(), theme.getThemeName());
    }

}
