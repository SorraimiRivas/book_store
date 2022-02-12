package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Customer;
import com.onlinestore.kodigonlinestore.Model.ShoppingCart;
import com.onlinestore.kodigonlinestore.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository SCRepository;

    @GetMapping("/all")
    public Iterable<ShoppingCart> getAllShoppingCart(){
        return SCRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<ShoppingCart> find(@PathVariable Long id){
        return SCRepository.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<ShoppingCart> save(@RequestBody ShoppingCart shoppincart){
        ShoppingCart obj = SCRepository.save(shoppincart);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ShoppingCart> delete(@PathVariable Long id){
        Optional<ShoppingCart> shoppincart = SCRepository.findById(id);

        if(shoppincart.isPresent()){
            SCRepository.deleteById(id);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
