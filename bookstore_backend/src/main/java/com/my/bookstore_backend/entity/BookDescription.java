package com.my.bookstore_backend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "bookdescription")
public class BookDescription {

    @Id
    private ObjectId id;

    private int bookId;

    private String bookDescription;

    public BookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }
}
