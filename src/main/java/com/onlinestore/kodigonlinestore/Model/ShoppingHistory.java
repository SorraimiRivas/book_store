package com.onlinestore.kodigonlinestore.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="shopping_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingHistory extends Invoice
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_shopping_history")
    private Long id;


}
