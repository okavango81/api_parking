package com.okavango.api_parking.repositories;

import com.okavango.api_parking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}