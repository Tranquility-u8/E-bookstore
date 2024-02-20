package com.my.bookstore_backend.dao;

import com.my.bookstore_backend.entity.Book;

import java.util.List;

public interface BookDao {
    Book findOne(Integer id);
    List<Book> getBooks();
    void saveBook(Book book);
    void delete(Integer bookId);

    List<Book> findBooksByTag(String tag);

    List<Book> findBooksByNameContaining(String tag);
}
