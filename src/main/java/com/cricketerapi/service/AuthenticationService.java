package com.cricketerapi.service;


import com.cricketerapi.entities.User;
import com.cricketerapi.dto.UserResponseDTO;
import com.cricketerapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    UserRepo userRepo;

    public User verifyUser(User loginUser) {
        Optional<User> existingUser = userRepo.findByEmail(loginUser.getEmail());
        if (existingUser.isPresent()) {
            return existingUser.get();
        }
        return userRepo.save(loginUser);
    }

}
