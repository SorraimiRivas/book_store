package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.ItemOrder;
import com.onlinestore.kodigonlinestore.Repository.ItemOrderRepository;
import com.onlinestore.kodigonlinestore.Service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item-order")
public class ItemOrderController {

    @Autowired
    private ItemOrderService service;

    @GetMapping("/all")
    public Iterable<ItemOrder> getAllItemOrder(){
        return service.getAllItemOrder();
    }

    @PostMapping("/save")
    public ResponseEntity<ItemOrder> saves(@RequestBody ItemOrder itemOrder){
        ItemOrder obj = service.save(itemOrder);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<ItemOrder> finds(@PathVariable Long id){
        return service.find(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ItemOrder> delete(@PathVariable Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
