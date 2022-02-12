package com.onlinestore.kodigonlinestore.Model;

import com.onlinestore.kodigonlinestore.Interface.ITotal;
import com.onlinestore.kodigonlinestore.Model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@Entity
@Table(name = "item_cart")
public class ItemOrder implements ITotal, Serializable {
   private Item item;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item_cart")
    private Long id;
    @Column(name = "quantity")
    private double quantity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_book")
    private Book idBook;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_shopping_cart")
    private ShoppingCart idShoppingCart;


    @Override
    @Column(name = "subtotal")
    public double getTotal() {
        return item.getItemPrice()*quantity;
    }
}

