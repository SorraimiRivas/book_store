package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
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


}