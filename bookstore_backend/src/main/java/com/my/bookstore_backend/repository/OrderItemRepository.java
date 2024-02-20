package com.my.bookstore_backend.repository;
import com.my.bookstore_backend.entity.Order;
import com.my.bookstore_backend.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface OrderItemRepository extends JpaRepository<Order,Integer> {
    @Query(value = "from OrderItem where order.id = :orderId ")
    List<OrderItem> getOrderItemByOrderId(int orderId);
}
