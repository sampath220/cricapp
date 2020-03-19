package com.cricketerapi.repository;

import com.cricketerapi.entities.Cricketer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CricketerRepo extends JpaRepository<Cricketer,Integer> {

}
