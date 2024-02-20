package com.my.bookstore_backend.dao;
import com.my.bookstore_backend.entity.Order;
import com.my.bookstore_backend.entity.OrderItem;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface OrderItemDao {
    List<OrderItem> getOrderItemByOrderId(int orderId);
    @Transactional(propagation = Propagation.REQUIRED)
    Order saveOrderItem(Order order);
}
