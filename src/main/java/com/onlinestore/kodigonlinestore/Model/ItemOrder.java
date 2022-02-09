package com.onlinestore.kodigonlinestore.Model;

import com.onlinestore.kodigonlinestore.Interface.ITotal;
import com.onlinestore.kodigonlinestore.Model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter@Setter

public class ItemOrder implements ITotal {
    private Item item;
    private double quantity;

    public ItemOrder(){
    }

    @Override
    public double getTotal() {
        return item.getItemPrice()*quantity;
    }
}

