package com.onlinestore.kodigonlinestore.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private Long itemId;
    private String title;
    @Column(name="price")
    private float itemPrice;
    @Column(name="img")
    @Lob
    private byte[] itemImage;
    @Column(name="category")
    private String category;

}