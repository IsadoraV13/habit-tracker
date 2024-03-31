package com.isadora.habittracker.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "habit_user", uniqueConstraints = { @UniqueConstraint(name = "UniqueUsername", columnNames = { "username", "is_active" }) })
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String username;
    private Boolean isActive;
    private int score;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
