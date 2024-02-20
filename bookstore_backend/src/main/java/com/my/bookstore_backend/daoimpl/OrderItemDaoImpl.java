package com.my.bookstore_backend.daoimpl;

import com.alibaba.fastjson2.JSON;
import com.my.bookstore_backend.dao.OrderItemDao;
import com.my.bookstore_backend.entity.Order;
import com.my.bookstore_backend.entity.OrderItem;
import com.my.bookstore_backend.entity.User;
import com.my.bookstore_backend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getOrderItemByOrderId(int orderId) {
        return orderItemRepository.getOrderItemByOrderId(orderId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Order saveOrderItem(Order order) {
        return orderItemRepository.save(order);
    }

}
