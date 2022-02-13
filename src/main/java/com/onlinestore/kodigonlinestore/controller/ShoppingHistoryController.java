package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Invoice;
import com.onlinestore.kodigonlinestore.Model.ShoppingCart;
import com.onlinestore.kodigonlinestore.Model.ShoppingHistory;
import com.onlinestore.kodigonlinestore.Repository.ShoppingCartRepository;
import com.onlinestore.kodigonlinestore.Repository.ShoppingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shopping-history")
public class ShoppingHistoryController {

    @Autowired
    private ShoppingHistoryRepository SHRepository;

    @GetMapping("/all")
    public Iterable<ShoppingHistory> getAllShoppingCart(){
        return SHRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<ShoppingHistory> find(@PathVariable Long id){
        return SHRepository.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<ShoppingHistory> save(@RequestBody ShoppingHistory shoppingHistory){
        ShoppingHistory obj = SHRepository.save(shoppingHistory);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping("/pay")
    public ResponseEntity<ShoppingHistory> pay(@RequestBody Invoice shoppincart){
        ShoppingHistory obj = SHRepository.save((ShoppingHistory) shoppincart);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ShoppingHistory> delete(@PathVariable Long id){
        Optional<ShoppingHistory> shoppingHistory = SHRepository.findById(id);

        if(shoppingHistory.isPresent()){
            SHRepository.deleteById(id);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
