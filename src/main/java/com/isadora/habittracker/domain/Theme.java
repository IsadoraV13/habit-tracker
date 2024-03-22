package com.isadora.habittracker.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "theme")
public class Theme {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String themeName; // e.g. health, career progression, family

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Theme() {

    }

    public int getId() {
        return id;
    }

    public String getThemeName() {
        return themeName;
    }

    public User getUser() {
        return user;
    }
}
