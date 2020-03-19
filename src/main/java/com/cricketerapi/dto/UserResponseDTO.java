package com.cricketerapi.dto;

import com.cricketerapi.entities.User;
import lombok.Data;

@Data
public class UserResponseDTO {
    User user;
    String message;
}
