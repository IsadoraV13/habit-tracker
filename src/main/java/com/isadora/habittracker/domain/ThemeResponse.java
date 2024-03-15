package com.isadora.habittracker.domain;

public record ThemeResponse(int themeId, String themeName) {

    public static ThemeResponse of(Theme theme) {
        return new ThemeResponse(theme.getThemeId(), theme.getThemeName());
    }

}
