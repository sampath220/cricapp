package com.cricketerapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "cricketers")
public class Cricketer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cricketer_id")
    private int id;

    private String name;

    private String country;

    @ManyToMany(mappedBy = "cricketers")
    private List<User> users;
}
