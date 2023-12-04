package com.okavango.api_parking.entities.dtos;

import com.okavango.api_parking.entities.User;
import lombok.Getter;

@Getter
public class UserMinDTO {
    private Long id;
    private String username;
    private String role;

    public UserMinDTO(User user){
        String permission = String.valueOf(user.getRole());
        id = user.getId();
        username = user.getUsername();
        role = permission.substring("ROLE_".length());
    }
}
