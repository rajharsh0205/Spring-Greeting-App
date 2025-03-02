package com.tit.greetingapp.controller;

import com.tit.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/service")
    public Greeting getServiceGreeting() {
        return new Greeting(greetingService.getGreetingMessage()); // Uses service layer
    }

    // UC3: Personalized Greeting (New Endpoint)
    @GetMapping("/personalized")
    public Greeting getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getPersonalizedGreeting(firstName, lastName));
    }

    //  UC4 - Save a Greeting Message
    @PostMapping("/save")
    public com.tit.greetingapp.model.Greeting saveGreeting(@RequestBody Greeting request) {
        return greetingService.saveGreeting(request.getMessage()); // Save in DB
    }

    // UC5 - Fetch Greeting by ID
    @GetMapping("/{id}")
    public com.tit.greetingapp.model.Greeting getGreeting(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/list")
    public List<com.tit.greetingapp.model.Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }


    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, this is a GET request!");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello, this is a POST request!");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello, this is a PUT request!");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello, this is a DELETE request!");
    }

    static class Greeting {
        private String message;

        public Greeting(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}