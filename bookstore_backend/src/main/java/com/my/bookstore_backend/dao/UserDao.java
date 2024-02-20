package com.my.bookstore_backend.dao;

import com.my.bookstore_backend.entity.User;

import java.util.List;

public interface UserDao {
    User checkUser(String username, String password);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserByName(String username);
}
