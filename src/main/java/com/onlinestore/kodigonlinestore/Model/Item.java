package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public abstract class Item {
    private String title;
    private String itemId;
    private String itemPrice;
    private String itemImage;
    private String category;

    public Item(String title,
                String itemId,
                String itemPrice,
                String itemImage,
                String category) {
        this.title = title;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
        this.category = category;
    }

    public Item(String itemId) {
        this.itemId = itemId;
    }
}