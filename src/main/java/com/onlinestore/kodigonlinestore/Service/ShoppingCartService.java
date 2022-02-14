package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.ShoppingCart;
import com.onlinestore.kodigonlinestore.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository SCRepository;

    public Iterable<ShoppingCart> getAllShoppingCart(){
        return SCRepository.findAll();
    }

    public Optional<ShoppingCart> find(Long id){
        return SCRepository.findById(id);
    }

    public ShoppingCart save(ShoppingCart shoppincart){
        return SCRepository.save(shoppincart);
    }

    public boolean delete(Long id){
        Optional<ShoppingCart> shoppincart = SCRepository.findById(id);

        if(shoppincart.isPresent()){
            SCRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
