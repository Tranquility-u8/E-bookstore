package com.my.bookstore_backend.daoimpl;

import com.my.bookstore_backend.entity.Order;
import com.my.bookstore_backend.repository.OrderRepository;
import com.my.bookstore_backend.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return orderRepository.getOrderByUserId(userId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
