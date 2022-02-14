package com.onlinestore.kodigonlinestore.Controller;


import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import com.onlinestore.kodigonlinestore.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class CustomerController  {

    @Autowired
    private CustomerService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('Admin')")
    public Iterable<Customer> getAllCustomer() {
        return service.getAllCustomer();
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasRole('Admin')")
    public Optional<Customer> find(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        Customer obj = service.save(customer);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('Admin','User')")
    public ResponseEntity<Customer> update(@RequestBody Customer cus){
        if (Objects.isNull(service.update(cus))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(cus, HttpStatus.OK);
        }
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


