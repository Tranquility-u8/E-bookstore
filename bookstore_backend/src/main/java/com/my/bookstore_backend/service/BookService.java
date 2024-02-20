package com.my.bookstore_backend.service;

import com.my.bookstore_backend.dto.NewBookDTO;
import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.utils.msgutils.Msg;

import java.util.List;

public interface BookService {

    Book findBookById(Integer id);
    List<Book> getBooks();

    List<Book> findBooksByTag(String tag);

    Msg addBook(NewBookDTO newBookDTO);

    Msg deleteBook(Integer bookId);

    Msg editBook(NewBookDTO newBookDTO);

    List<Book> findBooksByNameContaining(String bookName);
}
