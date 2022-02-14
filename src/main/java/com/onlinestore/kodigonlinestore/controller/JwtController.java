package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.JwtRequest;
import com.onlinestore.kodigonlinestore.Model.JwtResponse;
import com.onlinestore.kodigonlinestore.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService service;

    @PostMapping("/auth")
    public JwtResponse createJwtToken(@RequestBody JwtRequest request) throws Exception {
        return service.createJwtToken(request);
    }

}
