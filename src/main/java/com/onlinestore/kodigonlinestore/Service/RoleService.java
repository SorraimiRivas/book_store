package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Model.Role;
import com.onlinestore.kodigonlinestore.Model.ShoppingCart;
import com.onlinestore.kodigonlinestore.Repository.CustomerRepository;
import com.onlinestore.kodigonlinestore.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private CustomerRepository service;


    public Role createRole(Role role){
        return repository.save(role);
    }

    public void initRoles(){

            Role admin = new Role();
            admin.setRoleName("Admin");
            admin.setDescription("This user have privileges to manage and create data");
            repository.save(admin);

            Role user = new Role();
            user.setRoleName("User");
            user.setDescription("Default users recently created");
            repository.save(user);

            long a = 10;
            if(!service.existsById(a)) {
                Customer cos = new Customer();
                cos.setUserId(a);
                cos.setEmail("hectortaborahjtm@gmail.com");
                cos.setName("Hector");
                cos.setLastName("Tabora");
                cos.setPassword("12345678");
                Set<Role> userRole = new HashSet<Role>();
                userRole.add(user);
                cos.setRole(userRole);
                service.save(cos);
            }

            long b = 11;
            if(!service.existsById(b)) {
                Customer cosAdmin = new Customer();
                cosAdmin.setUserId(b);
                cosAdmin.setEmail("hectortaborahjtm@gmail.com");
                cosAdmin.setName("admin");
                cosAdmin.setLastName("admin");
                cosAdmin.setPassword("12345678");
                Set<Role> adminRole = new HashSet<Role>();
                adminRole.add(admin);
                cosAdmin.setRole(adminRole);
                service.save(cosAdmin);
            }

    }

}
