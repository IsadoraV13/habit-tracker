package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "theme")
public class Theme {
    @Id
    private int themeId;
    private String themeName; // e.g. health, career progression, family

    public Theme() {

    }

    public int getThemeId() {
        return themeId;
    }

    public String getThemeName() {
        return themeName;
    }

}
