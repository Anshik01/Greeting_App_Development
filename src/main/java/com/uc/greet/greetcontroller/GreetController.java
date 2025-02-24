package com.uc.greet.greetcontroller;

import com.uc.greet.entity.Greeting;
import com.uc.greet.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetController {
    private static final String template = "Hello, %s!";

    @GetMapping("/greet")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(String.format(template, name));
    }

    @PostMapping("/post")
    public Greeting postGreeting(@RequestBody User user){
        return new Greeting(String.format(template, user.getFirstName() + " " + user.getLastName() + "!"));
    }

    @PutMapping("/put/{firstName}")
    public Greeting putGreeting(@PathVariable String firstName,
                                @RequestParam(value = "lastName") String lastName){
        return new Greeting(String.format(template, firstName + " " + lastName + "!"));
    }

    @DeleteMapping("/delete/{name}")
    public Greeting deleteGreeting(@PathVariable String name){
        return new Greeting(String.format("User name " + name + " Deleted successfully!"));
    }
}
