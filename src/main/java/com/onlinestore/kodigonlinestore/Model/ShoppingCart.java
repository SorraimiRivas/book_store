package com.onlinestore.kodigonlinestore.Model;

import com.onlinestore.kodigonlinestore.Interface.IPurchase;
import com.onlinestore.kodigonlinestore.Interface.ISubTotal;
import com.onlinestore.kodigonlinestore.Interface.ITax;
import com.onlinestore.kodigonlinestore.Interface.ITotal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter

public class ShoppingCart extends Invoice implements ITax, ISubTotal, ITotal, IPurchase {

    Long id;

    @Override
    public double getTax() {
        return 0;
    }

    @Override
    public double getSubTotal() {
        return 0;
    }

    @Override
    public double getTotal() {
        return 0;
    }

    @Override
    public void add(ItemOrder adder) {

    }

    @Override
    public void remove(ItemOrder remover) {

    }
}
