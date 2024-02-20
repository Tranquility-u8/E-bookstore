package com.my.bookstore_backend.dto;

import com.my.bookstore_backend.entity.BookDescription;
import lombok.Getter;

@Getter
public class NewBookDTO {
    private Integer bookId;
    private String bookName;
    private String author;
    private String isbn;
    private Integer price;
    private Integer originPrice;
    private String description;
    private String imageUrl;
    private Integer inventory;
    private String tag;
}
