package com.onlinestore.kodigonlinestore.Controller;
import com.onlinestore.kodigonlinestore.Model.Item;

public class ItemOrder implements com.onlinestore.kodigonlinestore.Controller.ITotal {
    private Item item;
    private int quantity;

    public ItemOrder(com.onlinestore.kodigonlinestore.Model.Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public double getTotal() {
        return 0;
    }
}

