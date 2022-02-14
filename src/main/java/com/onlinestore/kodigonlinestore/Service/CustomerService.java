package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Model.Role;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import com.onlinestore.kodigonlinestore.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> find(Long id){
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer){
        Customer cos = prepareDefCustomer(customer);
        return customerRepository.save(cos);
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

    public Customer prepareDefCustomer(Customer def){
        Optional<Role> defaultRole =roleRepository.findById("User");
        if(defaultRole.isPresent()) {
            Set<Role> setRole = new HashSet<>();
            setRole.add(defaultRole.get());
            def.setRole(setRole);
        }
        return def;

    }


}
