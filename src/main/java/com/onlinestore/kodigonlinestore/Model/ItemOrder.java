package com.onlinestore.kodigonlinestore.Model;
import com.onlinestore.kodigonlinestore.Interface.ITotal;
import com.onlinestore.kodigonlinestore.Model.Item;

public class ItemOrder implements ITotal {
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

