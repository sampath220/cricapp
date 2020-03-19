package com.cricketerapi.repository;

import com.cricketerapi.entities.Cricketer;
import com.cricketerapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT c FROM User u INNER JOIN Cricketer c ON u.id=c.id where u.id=:id and c.name=:name and c.country=:country")
    Cricketer findByCricketerNameAndCountry(@Param("id") Integer userId,@Param("name") String name,@Param("country") String country);
}
