package com.ahmn.tacoonline.data;

import com.ahmn.tacoonline.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
