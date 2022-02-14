package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.ShoppingCart;
import com.onlinestore.kodigonlinestore.Repository.ShoppingCartRepository;
import com.onlinestore.kodigonlinestore.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService service;

    @GetMapping("/all")
    public Iterable<ShoppingCart> getAllShoppingCart(){
        return service.getAllShoppingCart();
    }

    @GetMapping("/find/{id}")
    public Optional<ShoppingCart> finds(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping("/save")
    public ResponseEntity<ShoppingCart> saves(@RequestBody ShoppingCart shoppincart){
        ShoppingCart obj = service.save(shoppincart);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ShoppingCart> delete(@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
