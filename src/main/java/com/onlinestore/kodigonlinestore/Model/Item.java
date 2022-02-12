package com.onlinestore.kodigonlinestore.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_book")
    private Long itemId;
    @Column(name="title")
    private String title;
    @Column(name="price_book")
    private float itemPrice;
    @Column(name="img")
    private byte[] itemImage;
    @Column(name="category")
    private String category;

}