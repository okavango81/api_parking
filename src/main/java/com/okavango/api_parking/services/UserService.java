package com.okavango.api_parking.services;

import com.okavango.api_parking.entities.User;
import com.okavango.api_parking.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


}
