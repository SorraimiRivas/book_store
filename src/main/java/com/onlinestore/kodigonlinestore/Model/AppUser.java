package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name="pass")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                @JoinColumn(name = "COSTUMER_ID")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

}