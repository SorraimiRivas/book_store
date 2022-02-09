package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter @Setter
@MappedSuperclass
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String title;
    private String itemPrice;
    private String itemImage;
    private String category;

    public Item(String title,
                Long itemId,
                String itemPrice,
                String itemImage,
                String category) {
        this.title = title;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.category = category;
    }

    public Item() {

    }
}