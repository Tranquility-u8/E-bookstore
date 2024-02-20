package com.my.bookstore_backend.controller;

import com.my.bookstore_backend.dto.NewBookDTO;
import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.service.CountService;
import com.my.bookstore_backend.utils.msgutils.Msg;
import com.my.bookstore_backend.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CountService countService;

    @RequestMapping("/getBooks")
    public List<Book> getBooks() {
        System.out.println("getBooks");
        return bookService.getBooks();
    }

    @RequestMapping("/findBooksByTag")
    public List<Book> findBooksByTag(@RequestParam("tag") String tag){
        if(Objects.equals(tag, "所有"))
            return bookService.getBooks();
        System.out.println("findBooksByTag");
        return bookService.findBooksByTag(tag);
    }

    @RequestMapping("/getBook")
    public Book getBook(@RequestParam("bookId") Integer bookId){
        System.out.println("getBook");
        return bookService.findBookById(bookId);
    }

    @RequestMapping("/addBook")
    public Msg addBook(@RequestBody NewBookDTO newBookDTO){
        System.out.println("addBook");
        return bookService.addBook(newBookDTO);
    }

    @RequestMapping("/deleteBook")
    public Msg deleteBook(@RequestParam("bookId") Integer bookId){
        System.out.println("deleteBook");
        return bookService.deleteBook(bookId);
    }

    @RequestMapping("/editBook")
    public Msg editBook(@RequestBody NewBookDTO newBookDTO){
        System.out.println("editBook");
        return bookService.editBook(newBookDTO);
    }

    @RequestMapping("/countKeywords")
    public void countKeywords(){
        System.out.println("countKeywords");
        List<String> list = Arrays.asList("Java", "JavaScript", "C++", "Programming", "Star", "Robot");
        countService.countKeywords("test.txt", list);
    }

    @QueryMapping
    public List<Book> findBooksByName(@Argument String bookName){
        System.out.println("findBooksByNameContaining");
        return bookService.findBooksByNameContaining(bookName);
    }
}
