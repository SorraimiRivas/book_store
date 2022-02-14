package com.onlinestore.kodigonlinestore.Service;

import com.onlinestore.kodigonlinestore.Model.Invoice;
import com.onlinestore.kodigonlinestore.Model.ShoppingHistory;
import com.onlinestore.kodigonlinestore.Repository.ShoppingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.onlinestore.kodigonlinestore.Util.Mail.SendBillTo;

@Service
public class ShoppingHistoryService {

    @Autowired
    private ShoppingHistoryRepository SHRepository;

    public Iterable<ShoppingHistory> getAllShoppingCart(){
        return SHRepository.findAll();
    }

    public Optional<ShoppingHistory> find(Long id){
        return SHRepository.findById(id);
    }

    public ShoppingHistory save(ShoppingHistory shoppingHistory){
        return SHRepository.save(shoppingHistory);
    }

    public ShoppingHistory pay(Invoice shoppincart) throws Exception {
        SendBillTo((ShoppingHistory)shoppincart,shoppincart.getIdCustomer());
        return SHRepository.save((ShoppingHistory) shoppincart);
    }

    public boolean delete(Long id){
        Optional<ShoppingHistory> shoppingHistory = SHRepository.findById(id);
        if(shoppingHistory.isPresent()){
            SHRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

}
