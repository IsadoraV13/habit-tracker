package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "themes")
public class Theme {
    @Id
    private int themeId;
    private int themeName;

    public Theme() {

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
