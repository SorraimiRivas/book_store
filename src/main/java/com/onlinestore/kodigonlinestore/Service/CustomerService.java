package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Model.Role;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import com.onlinestore.kodigonlinestore.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

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

    public Optional<Customer> findWithEmail(String mail){
        List<Customer> allCos = (List<Customer>) customerRepository.findAll();
        Optional<Customer> customer;
        customer = allCos.stream().filter((n)->Objects.
                equals(n.getEmail(),mail)).findFirst();
        return customer;
    }


    public Customer save(Customer customer){
        Customer cos = prepareDefCustomer(customer);
        return customerRepository.save(cos);
    }

    public Customer update(Customer cus){
        List<Customer> obj = (List<Customer>)customerRepository.findAll();

        Optional<Customer> customer;
        customer = obj.stream().filter((n)->Objects.
                equals(n.getUserId(), cus.getUserId())).findFirst();

        if (customer.isEmpty()) {
            return null;
        }else {
            customerRepository.save(customer.get());
            return customer.get();
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
