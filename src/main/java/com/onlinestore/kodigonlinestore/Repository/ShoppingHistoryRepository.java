package com.onlinestore.kodigonlinestore.Repository;

import com.onlinestore.kodigonlinestore.Model.ShoppingHistory;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ShoppingHistoryRepository extends CrudRepository<ShoppingHistory, Serializable> {
}
