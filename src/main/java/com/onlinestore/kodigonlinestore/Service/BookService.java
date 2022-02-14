package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Book;
import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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

    public Optional<Book> findWithTitle(String name){
        List<Book> allCos = (List<Book>) repository.findAll();
        Optional<Book> customer;
        customer = allCos.stream().filter((n)->Objects.
                equals(n.getTitle(),name)).findFirst();
        return customer;
    }
    public List<Book> findWithCategory(String cat){
        List<Book> allCos = (List<Book>) repository.findAll();
        List<Book> customer;
        customer = allCos.stream().filter((n)->Objects.deepEquals
                (n.getCategory(),cat)).toList();
        return customer;
    }
    public List<Book> findWithAuthor(String author){
        List<Book> allCos = (List<Book>) repository.findAll();
        List<Book> customer;
        customer = allCos.stream().filter((n)->Objects.
                equals(n.getAuthor(),author)).toList();
        return customer;
    }

    public List<Book> findWithEditorial(String editorial){
        List<Book> allCos = (List<Book>) repository.findAll();
        List<Book> customer;
        customer = allCos.stream().filter((n)->Objects.
                equals(n.getEditorial(),editorial)).toList();
        return customer;
    }

    public List<Book> findWithPrice(float[] price){
        List<Book> allCos = (List<Book>) repository.findAll();
        List<Book> customer=null;
        if(price.length<2) {
            customer = allCos.stream().filter((n) -> (n.getItemPrice() < price[0])).toList();
        }else if(price.length<3){
            customer = allCos.stream().filter((n) -> (n.getItemPrice() > price[0] && n.getItemPrice() < price[1])).toList();
        }
        return customer;
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
