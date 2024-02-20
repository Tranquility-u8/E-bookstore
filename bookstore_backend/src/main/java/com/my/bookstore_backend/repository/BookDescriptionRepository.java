package com.my.bookstore_backend.repository;

import com.my.bookstore_backend.entity.BookDescription;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookDescriptionRepository extends MongoRepository<BookDescription, ObjectId> {
    Optional<BookDescription> findByBookId(int bookId);
    Optional<BookDescription> deleteByBookId(int bookId);
}
