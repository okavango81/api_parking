package com.okavango.api_parking.services;

import com.okavango.api_parking.entities.User;
import com.okavango.api_parking.entities.dtos.UserMinDTO;
import com.okavango.api_parking.entities.dtos.UserRegistrationDTO;
import com.okavango.api_parking.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<UserMinDTO> registration(UserRegistrationDTO userRegistrationDTO) {
        User user = new User(userRegistrationDTO.getUsername(), userRegistrationDTO.getPassword());
        user = userRepository.save(user);
        UserMinDTO newUser = new UserMinDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


    @Transactional(readOnly = true)
    public ResponseEntity<UserMinDTO> searchById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            UserMinDTO userFound = new UserMinDTO(user.get());
            return ResponseEntity.ok().body(userFound);
        } else {
            throw new RuntimeException("Not Found");
        }
    }

    @Transactional(readOnly = true)
    public List<UserMinDTO> returnAll() {
        return userRepository.findAll().stream().map(UserMinDTO::new).toList();
    }

    @Transactional
    public ResponseEntity<Void> deleteRecord(Long id){
         userRepository.deleteById(id);
         return  ResponseEntity.noContent().build();
    }


}
