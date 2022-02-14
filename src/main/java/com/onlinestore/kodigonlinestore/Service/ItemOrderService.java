package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.ItemOrder;
import com.onlinestore.kodigonlinestore.Repository.ItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ItemOrderService {

    @Autowired
    private ItemOrderRepository ITRepository;

    public Iterable<ItemOrder> getAllItemOrder(){
        return ITRepository.findAll();
    }

    public ItemOrder save(ItemOrder itemOrder){return ITRepository.save(itemOrder);}

    public Optional<ItemOrder> find(Long id){
        return ITRepository.findById(id);
    }

    public boolean delete(Long id){
        Optional<ItemOrder> itemOrder = ITRepository.findById(id);
        if(itemOrder.isPresent()){
            ITRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
