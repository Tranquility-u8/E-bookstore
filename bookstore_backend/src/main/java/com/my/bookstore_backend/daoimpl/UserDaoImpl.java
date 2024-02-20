package com.my.bookstore_backend.daoimpl;
import com.alibaba.fastjson2.JSON;
import com.my.bookstore_backend.dao.UserDao;
import com.my.bookstore_backend.entity.User;
import com.my.bookstore_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public User checkUser(String username, String password){
        return userRepository.checkUser(username,password);
    }

    @Override
    public User getUserById(Integer userId) {
        User user;
        try {
            String user_str = (String) redisTemplate.opsForValue().get("user" + userId);
            if(user_str == null){
                user =  userRepository.getById(userId);
                redisTemplate.opsForValue().set("user" + userId, JSON.toJSONString(user));
            }
            else{
                user = JSON.parseObject(user_str, User.class);
            }
        } catch (RedisConnectionFailureException e){
            user =  userRepository.getById(userId);
            System.out.println("RedisConnectionFailure: getUserById");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        try {
            redisTemplate.opsForValue().set("user" + user.getUserId(), JSON.toJSONString(user));
        } catch (RedisConnectionFailureException e){
            System.out.println("RedisConnectionFailure: saveUser");
        }
        userRepository.save(user);
    }

    @Override
    public User getUserByName(String username) {
        return userRepository.getByUsername(username);
    }
}
