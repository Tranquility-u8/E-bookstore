package com.my.bookstore_backend.repository;
import com.my.bookstore_backend.entity.OrderLog;
import com.my.bookstore_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {

    List<OrderLog> findByUserOrderByEndTimeDesc(User user);
}