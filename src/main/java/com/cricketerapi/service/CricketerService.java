package com.cricketerapi.service;

import com.cricketerapi.entities.Cricketer;
import com.cricketerapi.entities.User;
import com.cricketerapi.repository.CricketerRepo;
import com.cricketerapi.repository.UserRepo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CricketerService {

    @Autowired
    private CricketerRepo cricketerRepo;

    @Autowired
    UserRepo userRepo;


    public List<Cricketer> getCricketers() {
        return cricketerRepo.findAll();
    }

    public Cricketer addCricketer(int userId, String name, String country) {
        Cricketer existingCricketer = userRepo.findByCricketerNameAndCountry(userId, name, country);
        System.out.println(existingCricketer);
        if (existingCricketer == null) {
            Cricketer cricketer = new Cricketer();
            cricketer.setName(name);
            cricketer.setCountry(country);
            cricketer.setUsers(new ArrayList<>());
            Optional<User> user = userRepo.findById(userId);
            if (user != null)
                cricketer.getUsers().add(user.get());
            return cricketerRepo.save(cricketer);
        }
        return null;
    }
}
