package com.isadora.habittracker.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "theme")
public class Theme {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
