package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/all")
    public Iterable<Book> getAllBooks() {return service.getAllBooks();}

    @PostMapping("/save")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Book> save(@RequestBody Book bok){
        Book obj = service.saveBook(bok);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @PostMapping("/update")
    @PreAuthorize("hasRole('Admin')")
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
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if(service.deleteBook(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findbycategory")
    public Iterable<Book> findCategory(@RequestBody String cat){
        return service.findWithCategory(cat);
    }
    @GetMapping("/findbyauthor")
    public Iterable<Book> findAuthor(@RequestBody String author){
        return service.findWithAuthor(author);
    }
    @GetMapping("/findbyeditorial")
    public Iterable<Book> findEditorial(@RequestBody String edi){
        return service.findWithEditorial(edi);
    }

    @GetMapping("/findbyprice")
    public Iterable<Book> findPrice(@RequestBody float[] price){
        return service.findWithPrice(price);
    }



}
