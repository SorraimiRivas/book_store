package com.onlinestore.kodigonlinestore.Interface;

import com.onlinestore.kodigonlinestore.Model.ItemOrder;

public interface IPurchase {
    public void add(ItemOrder adder);
    public void remove(ItemOrder remover);
}
