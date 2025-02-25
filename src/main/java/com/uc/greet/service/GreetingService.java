package com.uc.greet.service;

import com.uc.greet.dto.UserDTO;
import com.uc.greet.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uc.greet.repository.GreetingRepository;

import java.util.List;
import java.util.Optional;

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

    public Greeting getGreetingByID(Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);
        return greeting.orElse(null); // Return the greeting if found, otherwise return null
    }

    public List<Greeting> getAllGreetings(){
        return greetingRepository.findAll();
    }
}
