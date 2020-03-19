package com.cricketerapi.dto;

import com.cricketerapi.entities.Cricketer;
import lombok.Data;

import java.util.List;

@Data
public class CricketersListResponseDTO {

    List<Cricketer> cricketers;
}
