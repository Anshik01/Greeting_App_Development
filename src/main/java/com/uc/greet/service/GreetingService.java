package com.uc.greet.service;

import com.uc.greet.dto.UserDTO;
import com.uc.greet.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uc.greet.repository.GreetingRepository;

@Service
public class GreetingService {
    private static final String template = "Hello, %s!";

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting greet(UserDTO userDTO){
        String name;
        if(userDTO.getFirstName() != null && userDTO.getLastName() != null){
            name = userDTO.getFirstName() + " " + userDTO.getLastName();
        }
        else if(userDTO.getFirstName() != null){
            name = userDTO.getFirstName();
        }
        else if(userDTO.getLastName() != null){
            name = userDTO.getLastName();
        }
        else {
            name = "World";
        }

        Greeting greeting = new Greeting(String.format(template, name));
        return greetingRepository.save(greeting);
    }
}
