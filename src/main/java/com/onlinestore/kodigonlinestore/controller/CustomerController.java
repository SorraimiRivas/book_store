package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class CustomerController  {

    @Autowired
    private CustomerRepository customerRepository;

    
    @GetMapping("/all")
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

    @PostMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer cus){
        Iterable<Customer> obj = customerRepository.findAll();
        var ref = new Object() {
            Customer customer;
        };
        obj.forEach((n)->{
            ref.customer =(Objects.equals(n.getUserId(), cus.getUserId()))?cus: ref.customer;});

        if (ref.customer ==null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            customerRepository.save(ref.customer);
            return new ResponseEntity<>(ref.customer, HttpStatus.OK);
        }
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
