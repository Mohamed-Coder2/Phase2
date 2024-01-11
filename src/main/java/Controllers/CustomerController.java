package Controllers;

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

    private final ArrayList<Customer> customers = new ArrayList<>();
    Account acc1 = new Account("mohamed123","password123","Mohamed@gmail.com",10000);
    Account acc2 = new Account("ahmed123","pass123","Ahmed@gmail.com",20000);
    Account acc3 = new Account("Ali123","word123","Ali@gmail.com",30000);
    Customer customer1 = new Customer(acc1,10001,"Mohamed");
    Customer customer2 = new Customer(acc2, 10002, "Ahmed");
    Customer customer3 = new Customer(acc3, 10003, "Ali");

    public CustomerController() {
        // Add predefined customers to the list
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpUser(@RequestBody Account account) {
        // Create a new customer
        Customer newCustomer = new Customer();

        // Set customer details
        newCustomer.setName(account.getusername());  // Set name as username for simplicity
        newCustomer.setID(customers.size() + 10000); // A simple incrementing ID
        newCustomer.setaccount(account);

        // Add the new customer to the list
        customers.add(newCustomer);

        return new ResponseEntity<>("User "+newCustomer.getname()+" signed up successfully", HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllUsers() {
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
