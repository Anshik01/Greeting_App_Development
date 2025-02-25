package com.uc.greet.greetcontroller;

import com.uc.greet.dto.UserDTO;
import com.uc.greet.entity.Greeting;
import com.uc.greet.entity.User;
import com.uc.greet.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class GreetController {

    // Autowire the GreetingService to use its methods
    @Autowired
    private GreetingService greetingService;

    // Handles GET requests to /greeting/simple
    @GetMapping("/greet")
    public Greeting getSimpleHello(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        UserDTO userDTO = new UserDTO();
        // set first and last name
        userDTO.setFirstName(firstName);
        userDTO.setLastName(lastName);
        // Uses the service layer to get a simple greeting message
        return greetingService.greet(userDTO);
    }

    @GetMapping("/greet/{id}")
    public Greeting getGreetingByID(@PathVariable Long id){
        return greetingService.getGreetingByID(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreeting(){
        return greetingService.getAllGreetings();
    }
}
