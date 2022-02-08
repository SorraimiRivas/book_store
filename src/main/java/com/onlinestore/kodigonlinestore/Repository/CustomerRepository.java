package com.onlinestore.kodigonlinestore.Repository;

import com.onlinestore.kodigonlinestore.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
