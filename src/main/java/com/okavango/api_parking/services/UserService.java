package com.okavango.api_parking.services;

import com.okavango.api_parking.entities.User;
import com.okavango.api_parking.entities.dtos.UserMinDTO;
import com.okavango.api_parking.entities.dtos.UserRegistrationDTO;
import com.okavango.api_parking.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserMinDTO registration(UserRegistrationDTO userRegistrationDTO){
        User user = new User(userRegistrationDTO.getUsername(), userRegistrationDTO.getPassword());
        user = userRepository.save(user);
        return new UserMinDTO(user);
    }

}
