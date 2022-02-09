package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/users")
    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Customer> find(@PathVariable Long id){
        return customerRepository.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        Customer obj = customerRepository.save(customer);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            customerRepository.deleteById(id);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
