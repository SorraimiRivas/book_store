package com.onlinestore.kodigonlinestore.Controller;


import com.onlinestore.kodigonlinestore.Model.Role;
import com.onlinestore.kodigonlinestore.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/role")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping("/create")
    public Role createRole(@RequestBody Role role){
        return service.createRole(role);
    }

}
