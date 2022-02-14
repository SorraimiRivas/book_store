package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public Iterable<Book> getAllBooks() {
        return repository.findAll();
    }
    
    public Book saveBook(Book bok){
        return repository.save(bok);
    }

    public Book update(Book bok){
        List<Book> obj = (List<Book>) repository.findAll();

        Optional<Book> book;

        book = obj.stream().filter((n)->Objects.
                equals(n.getItemId(), bok.getItemId())).findFirst();

        if (book.isEmpty()) {
            return null;
        }else {
            repository.save(book.get());
            return book.get();
        }
    }

    public Optional<Book> findBook(Long id){
        return repository.findById(id);
    }

    public boolean deleteBook(Long id){

        Optional<Book> book = repository.findById(id);

        if(book.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


}
