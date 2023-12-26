package com.example.demo;

import Project.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// UserController.java
@RestController
@RequestMapping("/users")
public class Controller {

    private List<Customer> users = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Customer> createUser(@RequestBody Customer user) {
        users.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllUsers() {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
