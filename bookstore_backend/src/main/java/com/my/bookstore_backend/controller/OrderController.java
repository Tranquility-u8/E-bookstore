package com.my.bookstore_backend.controller;

import com.my.bookstore_backend.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.my.bookstore_backend.constant.Constant;
import com.my.bookstore_backend.service.OrderLogService;
import com.my.bookstore_backend.dto.GetOrderDTO;
import com.my.bookstore_backend.dto.NewOrderDTO;
import com.my.bookstore_backend.service.OrderService;
import com.my.bookstore_backend.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderLogService orderLogService;

    @RequestMapping("/getOrder")
    public List<GetOrderDTO> getOrder(){
        System.out.println("getOrder");
        return orderService.getOrder();
    }

    @RequestMapping("/checkOut")
    public void checkout(@RequestBody NewOrderDTO newOrderDTO) throws JsonProcessingException {
        System.out.println("checkOut");
        orderService.addOrder(newOrderDTO);
    }

    @RequestMapping("/checkOrderStatus")
    public Boolean checkOrderStatus() throws JsonProcessingException {
        System.out.println("checkOrderStatus");
        JSONObject auth = SessionUtil.getAuth();
        UserDao userDao = null;
        Boolean isSuccess = orderLogService.findLatestOrderStatus(userDao.getUserById(auth.getInt(Constant.USER_ID)));
        return isSuccess;
    }
}
