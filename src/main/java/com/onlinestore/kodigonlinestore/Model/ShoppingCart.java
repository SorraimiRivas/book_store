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
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_shopping_cart")
    private Long id;
    @Column(name="total")
    private float total;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_customer")

    private Customer idCustomer;


}
