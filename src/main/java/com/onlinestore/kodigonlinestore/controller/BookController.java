package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.BookRepository;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/get")
    public Iterable<Book> getAllCustomer() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book bok){
        Book obj = repository.save(bok);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }


}
