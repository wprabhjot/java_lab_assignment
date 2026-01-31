package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String greet(String name) {
        return "Welcome " + name + " to Spring Boot!";
    }

}