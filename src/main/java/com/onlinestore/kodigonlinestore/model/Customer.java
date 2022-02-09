package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter @Setter
public class  Customer extends AppUser{


    public Customer() {

    }

}