package com.uc.greet.service;

import com.uc.greet.entity.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";
    public Greeting simpleGreeting(){
        return new Greeting(String.format(template, "Anshik"));
    }
}
