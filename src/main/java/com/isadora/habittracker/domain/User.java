package com.isadora.habittracker.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "habit_user", uniqueConstraints = { @UniqueConstraint(name = "UniqueUsername", columnNames = { "username", "is_active" }) })
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isActive=" + isActive +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && getScore() == user.getScore() && getUsername().equals(user.getUsername()) && isActive.equals(user.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), isActive, getScore());
    }
}
