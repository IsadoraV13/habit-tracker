package com.isadora.habittracker.domain;

public record UserResponse(int userId, String username, Boolean isActive) {
    public static UserResponse of(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getIsActive());
    }
}
