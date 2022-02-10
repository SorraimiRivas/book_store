package com.onlinestore.kodigonlinestore.Model;


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
    @Column(name="total")
    private float total;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_customer")

    private Customer idCustomer;

    private double itemLoop(){
        return this.order.stream().mapToDouble(ItemOrder::getTotal).sum();
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
        this.order.add(item);
    }

    @Override
    public void remove(ItemOrder item) {
        this.order.remove(item);
    }

}
