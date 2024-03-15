package com.isadora.habittracker.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "habit_user", uniqueConstraints = { @UniqueConstraint(name = "UniqueUsername", columnNames = { "username", "is_active" }) })
public class User {
    @Id
    private int id;
    private String username;
//    @Column(name = "is_active")
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
