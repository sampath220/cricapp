package com.cricketerapi.controller;

import com.cricketerapi.entities.User;
import com.cricketerapi.dto.UserResponseDTO;
import com.cricketerapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/verifyUser")
    public ResponseEntity<UserResponseDTO> verifyCredentials(@RequestParam String email, @RequestParam String password) {
        User userCredentials = new User();
        userCredentials.setEmail(email);
        userCredentials.setPassword(password);
        User serviceResponse = authenticationService.verifyUser(userCredentials);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        if (!serviceResponse.equals(userCredentials)) {
            if (serviceResponse.getPassword().equals(userCredentials.getPassword())) {
                userResponseDTO.setUser(serviceResponse);
                userResponseDTO.setMessage("Welcome back");
            } else {
                userResponseDTO.setMessage("Invalid Email or Password");
                userResponseDTO.setUser(null);
            }
        } else {
            System.out.println(userCredentials.getId());
            userResponseDTO.setUser(serviceResponse);
            userResponseDTO.setMessage("Registered");
        }
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);

    }


//    @GetMapping("/users")
//    public String getUsers() {
//        return "hello";
//    }

}
