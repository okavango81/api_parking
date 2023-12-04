package com.okavango.api_parking.controllers;

import com.okavango.api_parking.entities.dtos.UserMinDTO;
import com.okavango.api_parking.entities.dtos.UserRegistrationDTO;
import com.okavango.api_parking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserMinDTO> created(@RequestBody UserRegistrationDTO userRegistrationDTO){
       return userService.registration(userRegistrationDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMinDTO> findBy(@PathVariable Long id){
        return userService.searchById(id);
    }

    @GetMapping
    public List<UserMinDTO> all(){
        return userService.returnAll();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserMinDTO> updatePass(
            @PathVariable Long id, @RequestBody UserRegistrationDTO userRegistrationDTO)
    {
        return userService.updatePassword(id, userRegistrationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return userService.deleteRecord(id);
    }
}
