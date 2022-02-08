package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter @Setter
public class  Customer extends AppUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    private int userId;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="is_admin")
    private boolean isAdmin;
    @Column(name="pass")
    private String password;


    public Customer(int userId,
                   String name,
                   String lastName,
                   String email,
                   boolean isAdmin,
                   String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public Customer(int userId) {
        this.userId = userId;
    }

    public Customer() {

    }
}