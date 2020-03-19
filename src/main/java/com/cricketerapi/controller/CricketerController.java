package com.cricketerapi.controller;

import com.cricketerapi.dto.CricketerResponseDTO;
import com.cricketerapi.entities.Cricketer;
import com.cricketerapi.repository.CricketerRepo;
import com.cricketerapi.service.CricketerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cricketer")
public class CricketerController {

    @Autowired
    CricketerService cricketerService;

    @PostMapping("/add")
    public ResponseEntity<CricketerResponseDTO> addCricketer(@RequestParam String name, @RequestParam String country, @RequestParam Integer userId) {
        CricketerResponseDTO cricketerResponseDTO = new CricketerResponseDTO();
        Cricketer cricketer = cricketerService.addCricketer(userId, name, country);
        cricketerResponseDTO.setCricketer(cricketer);
        if (cricketer == null) {
            cricketerResponseDTO.setResponseMessage("AlreadyExists");
        } else {
            cricketerResponseDTO.setResponseMessage("added");
        }
        return new ResponseEntity<>(cricketerResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/getCricketers")
    public ResponseEntity<List<Cricketer>> fetchCricketers() {
        return new ResponseEntity<>(cricketerService.getCricketers(), HttpStatus.OK);
    }

}
