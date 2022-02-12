package com.onlinestore.kodigonlinestore.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Invoice {

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,optional =false)
    @JoinColumn(name="id_customer")
    private Customer idCustomer;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="idShoppingCart")
    @JsonBackReference
    private List<ItemOrder> itemOrder;

}
