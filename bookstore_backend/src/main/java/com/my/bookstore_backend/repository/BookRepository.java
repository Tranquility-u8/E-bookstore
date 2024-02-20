package com.my.bookstore_backend.repository;
import com.my.bookstore_backend.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByTag(String tag);
    List<Book> findByBookNameContaining(String bookName);
}
