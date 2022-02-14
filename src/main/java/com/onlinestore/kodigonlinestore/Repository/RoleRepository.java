package com.onlinestore.kodigonlinestore.Repository;

import com.onlinestore.kodigonlinestore.Model.Role;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface RoleRepository extends CrudRepository<Role, Serializable> {
}
