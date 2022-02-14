package com.onlinestore.kodigonlinestore.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role {

    @Id
    private String roleName;
    private String description;

}
