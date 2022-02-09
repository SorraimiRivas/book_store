package com.onlinestore.kodigonlinestore.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


@Getter @Setter
@AllArgsConstructor
@Entity
public class Book extends Item{
    private String author;
    private String editorial;

    public Book() {
    }
}
