package com.onlinestore.kodigonlinestore.Repository;


import com.onlinestore.kodigonlinestore.Model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Serializable> {

}
