package com.application.controller;

import com.application.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppController {

    private List<User> users = new ArrayList<>();

    @GetMapping
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("...Reached Service.... Welcome to our portal.....");
    }

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        users.add(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") String userId){
        return ResponseEntity.ok(users.stream().filter(u -> u.getUsername().equals(userId)).findAny().orElse(null));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(users);
    }

}

