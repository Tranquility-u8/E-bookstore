package com.my.bookstore_backend.service;

import com.my.bookstore_backend.entity.User;

import java.util.Date;

public interface OrderLogService {

    void saveOrderLog(User user, Long orderId, Date startTime, Date endTime, boolean isSuccess, String errorMessage);

    Boolean findLatestOrderStatus(User user);
}
