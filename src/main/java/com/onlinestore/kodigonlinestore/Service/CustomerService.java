package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> find(Long id){
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer cus){
        Iterable<Customer> obj = customerRepository.findAll();
        var ref = new Object() {
            Customer customer;
        };
        obj.forEach((n)->{
            ref.customer =(Objects.equals(n.getUserId(), cus.getUserId()))?cus: ref.customer;});

        if (Objects.isNull(ref.customer)) {
            return null;
        }else {
            customerRepository.save(ref.customer);
            return ref.customer;
        }
    }

    public boolean delete(Long id){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            customerRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }


}
