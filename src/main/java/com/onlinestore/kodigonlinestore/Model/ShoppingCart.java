package com.onlinestore.kodigonlinestore.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlinestore.kodigonlinestore.Interface.IPurchase;
import com.onlinestore.kodigonlinestore.Interface.ISubTotal;
import com.onlinestore.kodigonlinestore.Interface.ITax;
import com.onlinestore.kodigonlinestore.Interface.ITotal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="shopping_cart")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart extends Invoice implements Serializable, ITax, ISubTotal, ITotal, IPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_shopping_cart")
    private Long id;
    private float total;


    private double itemLoop(){
        return this.getItemOrder().stream().mapToDouble(ItemOrder::getTotal).sum();
    }

    @Override
    public double getTax() {
        return (itemLoop())*0.15;
    }

    @Override
    public double getSubTotal() {
        return itemLoop();
    }

    @Override
    public double getTotal() {
        return getSubTotal()+getTax();
    }

    @Override
    public void add(ItemOrder item) {
        List<ItemOrder> lis =this.getItemOrder();
        lis.add(item);
        this.setItemOrder(lis);
    }

    @Override
    public void remove(ItemOrder item) {
        List<ItemOrder> lis =this.getItemOrder();
        lis.remove(item);
        this.setItemOrder(lis);
    }

}
