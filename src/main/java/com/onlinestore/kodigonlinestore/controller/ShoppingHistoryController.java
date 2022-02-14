package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.Invoice;
import com.onlinestore.kodigonlinestore.Model.ShoppingHistory;
import com.onlinestore.kodigonlinestore.Repository.ShoppingHistoryRepository;
import com.onlinestore.kodigonlinestore.Service.ShoppingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.onlinestore.kodigonlinestore.Util.Mail.SendBillTo;

@RestController
@RequestMapping("/shopping-history")
public class ShoppingHistoryController {

    @Autowired
    private ShoppingHistoryService service;

    @GetMapping("/all")
    public Iterable<ShoppingHistory> getAllShoppingCart(){
        return service.getAllShoppingCart();
    }

    @GetMapping("/find/{id}")
    public Optional<ShoppingHistory> find(@PathVariable Long id){
        return service.find(id);
    }

    @PostMapping("/save")
    public ResponseEntity<ShoppingHistory> save(@RequestBody ShoppingHistory shoppingHistory){
        ShoppingHistory obj = service.save(shoppingHistory);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping("/pay")
    public ResponseEntity<ShoppingHistory> pay(@RequestBody Invoice shoppincart) throws Exception {
        ShoppingHistory obj = service.pay(shoppincart);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ShoppingHistory> delete(@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
