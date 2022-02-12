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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item_cart")
    private Long id;
    private double quantity;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_item")
    private Item idItem;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_shopping_cart")
    private ShoppingCart idShoppingCart;


    @Override
    public double getTotal() {
        return idItem.getItemPrice()*quantity;
    }
}

