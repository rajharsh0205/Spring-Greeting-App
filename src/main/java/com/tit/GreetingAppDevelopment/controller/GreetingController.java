package com.tit.GreetingAppDevelopment.controller;

import com.tit.GreetingAppDevelopment.dto.GreetingRequest;
import com.tit.GreetingAppDevelopment.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> postGreeting(@RequestBody GreetingRequest greetingRequest) {
        Map<String, String> response = new HashMap<>();
        response.put("message","Hello " + greetingRequest.getFirstName() + " " + greetingRequest.getLastName());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from PUT method!");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from DELETE method!");
        return ResponseEntity.ok(response);
    }


}
