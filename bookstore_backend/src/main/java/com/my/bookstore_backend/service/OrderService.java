package com.my.bookstore_backend.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.my.bookstore_backend.dto.GetOrderDTO;
import com.my.bookstore_backend.dto.NewOrderDTO;
import com.my.bookstore_backend.entity.Order;

import java.util.List;

public interface OrderService {
    List<GetOrderDTO> getOrder();
    void addOrder(NewOrderDTO newOrderDTO) throws JsonProcessingException;
}
