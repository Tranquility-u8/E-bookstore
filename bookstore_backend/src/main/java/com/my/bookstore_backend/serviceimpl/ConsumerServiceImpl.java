package com.my.bookstore_backend.serviceimpl;


import com.my.bookstore_backend.dao.BookDao;
import com.my.bookstore_backend.dao.CartDao;
import com.my.bookstore_backend.dao.OrderDao;
import com.my.bookstore_backend.dao.UserDao;
import com.my.bookstore_backend.websocket.WebSocket;

import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.entity.Order;
import com.my.bookstore_backend.entity.OrderItem;
import com.my.bookstore_backend.service.ConsumerService;
import com.my.bookstore_backend.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.my.bookstore_backend.constant.Constant.FUNCTION_SERVICE_URL;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private WebSocket my_websocket;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    public Integer calculateOrderTotal(List<Map<String, Integer>> books) {
        Integer totalPrice = 0;
        for (Map<String, Integer> book : books) {
//            Integer bookTotal = restTemplate.postForObject(FUNCTION_SERVICE_URL, book, Integer.class); // calculate by microservice
            Integer bookTotal = book.get("price") * book.get("quantity");
            totalPrice += bookTotal;
        }
        return totalPrice;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @KafkaListener(id = "my_order",topics = "orders")
    public void consumeOrder(String msg){
        String data = msg.substring(1, msg.length() - 1).replace("\\", "");
        JSONObject order = JSONObject.fromObject(data);

        Order newOrder = new Order();
        Timestamp orderTime = new Timestamp(order.getLong("orderTime"));
        newOrder.setTime(orderTime);
        Integer userid = (Integer) order.getInt("user");
        newOrder.setUser(userDao.getUserById(userid));
        List<OrderItem> orderItemList = new LinkedList<>();
        JSONObject items = order.getJSONObject("items");

        Integer i = 0;
        List<Map<String, Integer>> books = new ArrayList<>();
        for (Object key: items.keySet()){
            JSONObject item = items.getJSONObject("item" + i.toString());
            i++;
            OrderItem newOrderItem = new OrderItem();
            Book book = bookDao.findOne(item.getInt("bookId"));
            Integer  number = item.getInt("quantity");
            int newInventory=book.getInventory() - number;
            if(newInventory < 0) {
                my_websocket.sendOneMessage(userid.toString(), "failure");
                return;
            }
            book.setInventory(newInventory);
            newOrderItem.setBook(book);
            newOrderItem.setBookNumber(number);
            newOrderItem.setPrice(book.getPrice());
            newOrderItem.setOrder(newOrder);
            orderItemList.add(newOrderItem);
            bookDao.saveBook(book);

            books.add(Map.of("price", book.getPrice(), "quantity", number));
        }

        newOrder.setTotalPrice(calculateOrderTotal((books)));
        newOrder.setOrderItem(orderItemList);

        cartDao.deleteCartByUserId(userid);
        orderDao.saveOrder(newOrder);


        my_websocket.sendOneMessage(userid.toString(), "success");
        System.out.println("success consuming order.");
    }
}
