package com.onlinestore.kodigonlinestore.Repository;

import com.onlinestore.kodigonlinestore.Model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Serializable> {



}
