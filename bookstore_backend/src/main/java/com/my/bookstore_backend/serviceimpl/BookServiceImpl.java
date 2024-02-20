package com.my.bookstore_backend.serviceimpl;

import com.my.bookstore_backend.entity.Book;
import com.my.bookstore_backend.constant.Constant;
import com.my.bookstore_backend.dao.BookDao;
import com.my.bookstore_backend.dto.NewBookDTO;
import com.my.bookstore_backend.entity.BookDescription;
import com.my.bookstore_backend.service.BookService;

import com.my.bookstore_backend.utils.msgutils.Msg;
import com.my.bookstore_backend.utils.msgutils.MsgUtil;
import com.my.bookstore_backend.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findBookById(Integer id){
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    @Override
    public List<Book> findBooksByTag(String tag) {
        return bookDao.findBooksByTag(tag);
    }

    @Override
    public Msg addBook(NewBookDTO newBookDTO) {
        JSONObject auth = SessionUtil.getAuth();
        if(auth != null && Objects.equals(auth.getString(Constant.USER_TYPE), "admin")){
            Book newBook=new Book();
            saveBook(newBookDTO, newBook);
            return MsgUtil.makeMsg(MsgUtil.SUCCESS,MsgUtil.SUCCESS_ADDBOOK);
        }
        else {
            return MsgUtil.makeMsg(MsgUtil.ERROR,MsgUtil.ERROR_ADDBOOK);
        }
    }

    @Override
    public Msg editBook(NewBookDTO newBookDTO) {
        JSONObject auth = SessionUtil.getAuth();
        if(auth != null && Objects.equals(auth.getString(Constant.USER_TYPE), "admin")){
            Book book=bookDao.findOne(newBookDTO.getBookId());
            saveBook(newBookDTO, book);
            return MsgUtil.makeMsg(MsgUtil.SUCCESS,MsgUtil.SUCCESS_EDITBOOK);
        }
        else {
            return MsgUtil.makeMsg(MsgUtil.ERROR,MsgUtil.ERROR_EDITBOOK);
        }
    }

    private void saveBook(NewBookDTO newBookDTO, Book book) {
        book.setBookName(newBookDTO.getBookName());
        book.setAuthor(newBookDTO.getAuthor());
        book.setDescription(newBookDTO.getDescription());
        book.setInventory(newBookDTO.getInventory());
        book.setImageUrl(newBookDTO.getImageUrl());
        book.setIsbn(newBookDTO.getIsbn());
        book.setPrice(newBookDTO.getPrice());
        book.setOriginPrice(newBookDTO.getOriginPrice());
        book.setTag(newBookDTO.getTag());
        bookDao.saveBook(book);
    }

    @Override
    public Msg deleteBook(Integer bookId) {
        JSONObject auth = SessionUtil.getAuth();
        if(auth != null && Objects.equals(auth.getString(Constant.USER_TYPE), "admin")){
            bookDao.delete(bookId);
            return MsgUtil.makeMsg(MsgUtil.SUCCESS,MsgUtil.SUCCESS_DELETEBOOK);
        }
        else{
            return MsgUtil.makeMsg(MsgUtil.ERROR,MsgUtil.ERROR_DELETEBOOK);
        }
    }

    @Override
    public List<Book> findBooksByNameContaining(String bookName) {
        return bookDao.findBooksByNameContaining(bookName);
    }
}
