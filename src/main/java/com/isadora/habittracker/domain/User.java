package com.isadora.habittracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueUsername", columnNames = { "username", "isActive" }) })
public class User {
    @Id
    private int userId;
    private String username;
    private Boolean isActive;
}
