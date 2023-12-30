package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;

@Entity
public class Theme {
    private int themeId;
    private int themeName;

    public Theme(int themeId, int themeName) {
        this.themeId = themeId;
        this.themeName = themeName;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getThemeName() {
        return themeName;
    }

    public void setThemeName(int themeName) {
        this.themeName = themeName;
    }
}
