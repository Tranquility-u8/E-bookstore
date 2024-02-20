package com.my.bookstore_backend.dao;

import com.my.bookstore_backend.entity.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderDao {
    List<Order> getOrderByUserId(int userId);
    List<Order> getAllOrders();

    Order saveOrder(Order order);
}
