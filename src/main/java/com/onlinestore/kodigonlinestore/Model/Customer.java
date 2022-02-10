package com.onlinestore.kodigonlinestore.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter @Setter
public class  Customer extends AppUser implements Serializable {

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "idCustomer")
@JsonBackReference
private List<ShoppingCart> shoppingcart;

    public Customer() {

    }

}