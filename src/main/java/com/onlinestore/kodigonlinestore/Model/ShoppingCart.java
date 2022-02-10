package com.onlinestore.kodigonlinestore.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class ShoppingCart extends Invoice implements Serializable,ITax, ISubTotal, ITotal, IPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_shopping_cart")
    private Long id;
    @Column(name="total")
    private float total;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_customer")

    private Customer idCustomer;

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
