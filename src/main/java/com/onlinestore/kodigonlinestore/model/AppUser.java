package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter @Setter
public abstract class  AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer")
    private Long userId;
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


    public AppUser(
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

    public AppUser(Long userId) {
        this.userId = userId;
    }

    public AppUser() {

    }
}