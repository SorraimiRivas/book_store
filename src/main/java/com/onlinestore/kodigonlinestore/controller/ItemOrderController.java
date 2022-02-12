package com.onlinestore.kodigonlinestore.Controller;

import com.onlinestore.kodigonlinestore.Model.ItemOrder;
import com.onlinestore.kodigonlinestore.Repository.ItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item-order")
public class ItemOrderController {

    @Autowired
    private ItemOrderRepository ITRepository;

    @GetMapping("/all")
    public Iterable<ItemOrder> getAllItemOrder(){
        return ITRepository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<ItemOrder> save(@RequestBody ItemOrder itemOrder){
        ItemOrder obj = ITRepository.save(itemOrder);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public Optional<ItemOrder> find(@PathVariable Long id){
        return ITRepository.findById(id);
    }


    @GetMapping("/delete/{id}")
    public ResponseEntity<ItemOrder> delete(@PathVariable Long id){
        Optional<ItemOrder> itemOrder = ITRepository.findById(id);

        if(itemOrder.isPresent()){
        ITRepository.deleteById(id);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
