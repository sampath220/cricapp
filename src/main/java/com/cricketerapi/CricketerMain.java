package com.cricketerapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CricketerMain {
    public static void main(String args[]) {
        SpringApplication.run(CricketerMain.class, args);
    }
}
