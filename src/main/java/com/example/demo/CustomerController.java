package com.example.demo;

import Project.Account;
import Project.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Customer Controller
@RestController
@RequestMapping("/")
public class CustomerController {

    private final List<Customer> customers = new ArrayList<>();

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody Account account) {
        // Create a new customer
        Customer newCustomer = new Customer();

        // Set customer details
        newCustomer.setName(account.getusername());  // Set name as username for simplicity
        newCustomer.setID(customers.size() + 1); // Assuming a simple incrementing ID
        newCustomer.setaccount(account);

        // Add the new customer to the list
        customers.add(newCustomer);

        return new ResponseEntity<>("User signed up successfully", HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
