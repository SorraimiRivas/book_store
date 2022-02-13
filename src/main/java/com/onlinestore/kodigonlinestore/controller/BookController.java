package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Repository.BookRepository;
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
    private BookRepository repository;

    @GetMapping("/all")
    public Iterable<Book> getAllBooks() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book bok){
        Book obj = repository.save(bok);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book bok){
        Iterable<Book> obj = repository.findAll();
        var ref = new Object() {
            Book book;
        };
        obj.forEach((n)->{
            ref.book =(Objects.equals(n.getItemId(), bok.getItemId()))?bok: ref.book;});

        if (ref.book ==null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            repository.save(ref.book);
            return new ResponseEntity<>(ref.book, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public Optional<Book> find(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        Optional<Book> book = repository.findById(id);

        if(book.isPresent()){
            repository.deleteById(id);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
