package com.okavango.api_parking.controllers;

import com.okavango.api_parking.entities.User;
import com.okavango.api_parking.entities.dtos.UserMinDTO;
import com.okavango.api_parking.entities.dtos.UserRegistrationDTO;
import com.okavango.api_parking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserMinDTO> created(@RequestBody UserRegistrationDTO userRegistrationDTO){
        UserMinDTO newUser = userService.registration(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

}
