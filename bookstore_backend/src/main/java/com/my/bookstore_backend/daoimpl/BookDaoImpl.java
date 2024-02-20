package com.my.bookstore_backend.daoimpl;
import com.alibaba.fastjson2.JSON;
import com.my.bookstore_backend.dao.BookDao;
import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.entity.BookDescription;
import com.my.bookstore_backend.entity.User;
import com.my.bookstore_backend.repository.BookDescriptionRepository;
import com.my.bookstore_backend.repository.BookRepository;
import com.my.bookstore_backend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDescriptionRepository bookDescriptionRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Book findOne(Integer id){
        Book book;
        Optional<BookDescription> description;
        try {
            String book_str = (String) redisTemplate.opsForValue().get("book" + id);
            if(book_str == null){
                book =  bookRepository.getById(id);
                description = bookDescriptionRepository.findByBookId(id);

                if(description.isPresent()){
                    book.setDescription(description.get().getBookDescription());
                }else {
                    book.setDescription(null);
                }
                System.out.println("findOneBook by repository");

                if(book != null)
                    redisTemplate.opsForValue().set("book" + id, JSON.toJSONString(book));
            }
            else{
                System.out.println("findOneBook by redis");
                book = JSON.parseObject(book_str, Book.class);
            }
        } catch (RedisConnectionFailureException e){
            System.out.println("RedisConnectionFailure: findOne");

            book =  bookRepository.getById(id);
            description = bookDescriptionRepository.findByBookId(id);

            if(description.isPresent()){
                book.setDescription(description.get().getBookDescription());
            }else {
                book.setDescription(null);
            }

            System.out.println("findOneBook by repository");
        }
        return book;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Optional<BookDescription> description;
        Set<String> keys;

        try {
            keys = redisTemplate.keys("book*");
            if (keys == null || keys.isEmpty()) {
                System.out.println("not found books in redis\ntry to getBooks by repository");
                books = bookRepository.findAll();
                for(Book book: books){
                    description = bookDescriptionRepository.findByBookId(book.getBookId());
                    if(description.isPresent()){
                        book.setDescription(description.get().getBookDescription());
//                        System.out.println(book.getDescription());
                    }else {
                        book.setDescription(null);
                        System.out.println("description not found in mongo");
                    }
                    redisTemplate.opsForValue().set("book" + book.getBookId(), JSON.toJSONString(book));
                }
                return books;
            }

            List<String> book_strs = redisTemplate.opsForValue().multiGet(keys);

            for (String book_str : book_strs) {
                books.add(JSON.parseObject(book_str, Book.class));
            }
            System.out.println("getBooks by redis");

        } catch (RedisConnectionFailureException e) {
            System.out.println("RedisConnectionFailure: getBooks");
            System.out.println("getBooks by repository");
            books = bookRepository.findAll();
            for(Book book: books){
                description = bookDescriptionRepository.findByBookId(book.getBookId());
                if(description.isPresent()){
                    book.setDescription(description.get().getBookDescription());
                }else {
                    book.setDescription(null);
                }
                redisTemplate.opsForValue().set("book" + book.getBookId(), JSON.toJSONString(book));
            }
        }

        return books;
    }

    @Override
    public void saveBook(Book book) {
        try {
            redisTemplate.opsForValue().set("book" + book.getBookId(), JSON.toJSONString(book));
        } catch (RedisConnectionFailureException e){
            System.out.println("RedisConnectionFailure: saveBook");
        }
        bookRepository.save(book);
        bookDescriptionRepository.insert(new BookDescription(book.getDescription()));
    }

    @Override
    public void delete(Integer bookId) {
        try {
            redisTemplate.delete("book" + bookId);
        } catch (RedisConnectionFailureException e){
            System.out.println("RedisConnectionFailure: delete");
        }
        bookRepository.deleteById(bookId);
        bookDescriptionRepository.deleteByBookId(bookId);
    }

    @Override
    public List<Book> findBooksByTag(String tag) {
        List<Book> books = new ArrayList<>();

        List<Object> tags = tagRepository.findRelatedTags(tag);
        String str =  tags.get(0).toString();
        String str2 = str.substring(1, str.length() - 1);
        String[] items = str2.split(",\\s*");
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replaceAll("\"", ""); // 移除引号
        }
        List<String> listWithDuplicates = Arrays.asList(items);
        Set<String> set = new HashSet<>(listWithDuplicates);
        set.add(tag);
        List<String> list = new ArrayList<>(set);

        if(!tags.isEmpty()){
            for (String tag__:list){
                List<Book> books_ = bookRepository.findByTag(tag__);
                books.addAll(books_);
            }
        } else return null;
        return books;
    }

    @Override
    public List<Book> findBooksByNameContaining(String bookName){
        return bookRepository.findByBookNameContaining(bookName);
    }
}
