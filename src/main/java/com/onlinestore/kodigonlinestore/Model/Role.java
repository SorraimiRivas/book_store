package com.onlinestore.kodigonlinestore.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private String roleName;
    private String description;

}
