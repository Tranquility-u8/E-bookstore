package com.my.bookstore_backend.repository;
import com.my.bookstore_backend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> getByUserId(Integer userId);
    void deleteByUserId(Integer userId);
    @Query(value = "from CartItem where userId = :userId and book.bookId = :bookId")
    CartItem getCartItemByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
}
