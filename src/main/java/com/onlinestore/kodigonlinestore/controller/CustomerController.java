package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/Users")
    public List<Customer> getAllAppUsers() {
        return customerRepository.findAll();
    }

}
