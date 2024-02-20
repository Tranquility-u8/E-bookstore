package com.my.bookstore_backend.serviceimpl;

import com.my.bookstore_backend.entity.User;
import com.my.bookstore_backend.entity.OrderLog;
import com.my.bookstore_backend.repository.OrderLogRepository;
import com.my.bookstore_backend.service.OrderLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderLogServiceImpl implements OrderLogService{
    private OrderLogRepository orderLogRepository;

    public OrderLogServiceImpl(OrderLogRepository orderLogRepository) {
        this.orderLogRepository = orderLogRepository;
    }

    @Autowired
    public void OrderLogService(OrderLogRepository orderLogRepository) {
        this.orderLogRepository = orderLogRepository;
    }

    @Override
    public void saveOrderLog(User user, Long orderId, Date startTime, Date endTime, boolean isSuccess, String errorMessage) {
        OrderLog orderLog = new OrderLog();
        orderLog.setUser(user);
        orderLog.setOrderId(orderId);
        orderLog.setStartTime(startTime);
        orderLog.setEndTime(endTime);
        orderLog.setIsSuccess(isSuccess);
        orderLog.setErrorMessage(errorMessage);
        orderLogRepository.save(orderLog);
    }

    @Override
    public Boolean findLatestOrderStatus(User user) {
        List<OrderLog> orderLogs = orderLogRepository.findByUserOrderByEndTimeDesc(user);
        if (!orderLogs.isEmpty()) {
            OrderLog latestOrderLog = orderLogs.get(0);
            if (latestOrderLog.isSuccess()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}