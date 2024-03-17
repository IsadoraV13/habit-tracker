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

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getIsActive() {
        return isActive;
    }

}
