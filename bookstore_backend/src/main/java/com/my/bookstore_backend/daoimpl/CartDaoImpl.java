package com.my.bookstore_backend.daoimpl;

import com.alibaba.fastjson2.JSON;
import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.entity.CartItem;
import com.my.bookstore_backend.repository.CartItemRepository;
import com.my.bookstore_backend.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem getCartItemById(Integer cartItemId) {
        CartItem cartItem;
        cartItem =  cartItemRepository.getById(cartItemId);
        return cartItem;
    }

    @Override
    public List<CartItem> getCartItemsByUserId(Integer userId) {
        return cartItemRepository.getByUserId(userId);
    }

    @Override
    public CartItem getCartItemByUserIdAndBookId(Integer userId, Integer bookId) {
        return cartItemRepository.getCartItemByUserIdAndBookId(userId,bookId);
    }

    @Override
    public void saveCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItemById(Integer cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void deleteCartByUserId(Integer userId) {
        cartItemRepository.deleteByUserId(userId);
    }


}
