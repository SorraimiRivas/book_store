package com.onlinestore.kodigonlinestore.Repository;

import com.onlinestore.kodigonlinestore.Model.Book;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BookRepository extends CrudRepository<Book, Serializable> {

}