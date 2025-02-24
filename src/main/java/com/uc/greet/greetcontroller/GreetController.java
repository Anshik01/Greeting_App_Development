package com.uc.greet.greetcontroller;

import com.uc.greet.entity.Greeting;
import com.uc.greet.entity.User;
import com.uc.greet.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {

    // Autowire the GreetingService to use its methods
    @Autowired
    private GreetingService greetingService;

    // Handles GET requests to /greeting/simple
    @GetMapping("/hello")
    public Greeting getSimpleHello(){
        // Uses the service layer to get a simple greeting message
        return greetingService.simpleGreeting();
    }
}
