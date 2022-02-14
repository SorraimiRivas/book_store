package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/all")
    public Iterable<Book> getAllBooks() {return service.getAllBooks();}

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book bok){
        Book obj = service.saveBook(bok);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book bok){
        if (Objects.isNull(service.update(bok))) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(bok, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public Optional<Book> find(@PathVariable Long id){
        return service.findBook(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if(service.deleteBook(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
