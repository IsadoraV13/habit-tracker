package com.isadora.habittracker.controller.response;

import com.isadora.habittracker.domain.User;

public record UserResponse(int userId, String username, int score, Boolean isActive) {
    public static UserResponse of(User user){
        return new UserResponse(user.getId(), user.getUsername(), user.getScore(), user.getActive());
    }
}
