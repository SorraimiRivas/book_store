package com.onlinestore.kodigonlinestore.Repository;

import com.onlinestore.kodigonlinestore.Model.ItemOrder;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface ItemOrderRepository extends CrudRepository<ItemOrder, Serializable> {
}
