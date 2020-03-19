package com.cricketerapi.dto;

import com.cricketerapi.entities.Cricketer;
import lombok.Data;

@Data
public class CricketerResponseDTO {

    private Cricketer cricketer;

    private String responseMessage;

}
