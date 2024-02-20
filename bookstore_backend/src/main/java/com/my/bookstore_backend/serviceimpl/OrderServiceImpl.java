package com.my.bookstore_backend.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.bookstore_backend.dao.UserDao;
import com.my.bookstore_backend.dto.GetOrderDTO;
import com.my.bookstore_backend.dto.NewOrderDTO;
import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.entity.Order;
import com.my.bookstore_backend.entity.OrderItem;
import com.my.bookstore_backend.utils.sessionutils.SessionUtil;
import com.my.bookstore_backend.constant.Constant;
import com.my.bookstore_backend.dao.BookDao;
import com.my.bookstore_backend.dao.CartDao;
import com.my.bookstore_backend.dao.OrderDao;
import com.my.bookstore_backend.service.OrderService;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<GetOrderDTO> getOrder() {
        JSONObject auth = SessionUtil.getAuth();
        if(auth != null){
            List<Order> orderList;
            if(auth.getString(Constant.USER_TYPE).equals("admin")){
                orderList=orderDao.getAllOrders();
            }
            else {
                orderList=orderDao.getOrderByUserId(auth.getInt(Constant.USER_ID));
            }
            List<GetOrderDTO> getOrderDTOList=new LinkedList<>();
            for(Order order:orderList){
                getOrderDTOList.add(new GetOrderDTO(order));
            }
            return getOrderDTOList;
        }
        else {
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addOrder(NewOrderDTO newOrderDTO) throws JsonProcessingException {
        JSONObject auth = SessionUtil.getAuth();
        if(auth != null){

            JSONObject order = new JSONObject();
            JSONObject items = new JSONObject();

            order.put("orderTime", System.currentTimeMillis());
            order.put("user", auth.getInt(Constant.USER_ID));

            Integer i = 0;
            for (NewOrderDTO.OrderItem orderItem: newOrderDTO.getOrderItemList()) {
                JSONObject item = new JSONObject();
                Book book = bookDao.findOne(orderItem.getBookId());
                item.put("bookId", orderItem.getBookId());
                item.put("quantity", orderItem.getBookNumber());
                item.put("price",book.getPrice());
                items.put("item" + i.toString(), item);
                i++;
            }
            order.put("items", items);
            System.out.println("send order to topic.");
            kafkaTemplate.send("orders", order.toString());
        }
    }
}
