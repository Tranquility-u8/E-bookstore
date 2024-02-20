//package com.my.bookstore_backend.graphql;
//
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import com.my.bookstore_backend.entity.Book;
//import com.my.bookstore_backend.repository.BookRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class BookQueryResolver implements GraphQLQueryResolver {
//
//    private final BookRepository bookRepository;
//
//    public BookQueryResolver(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    public List<Book> findBooksByNameContaining(String bookName) {
//        return bookRepository.findByBookNameContaining(bookName);
//    }
//}
