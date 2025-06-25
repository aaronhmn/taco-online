package com.ahmn.tacoonline.data;

import com.ahmn.tacoonline.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
