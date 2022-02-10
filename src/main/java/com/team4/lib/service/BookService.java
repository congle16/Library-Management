package com.team4.lib.service;

import java.util.List;

import com.team4.lib.dao.BookDao;
import com.team4.lib.domain.Book;
import com.team4.lib.model.mapper.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements BookDao {

  @Autowired
  BookRepository bookRepository;

  @Override
  public List<Book> getListBook() {
    return bookRepository.getListBook();
  }

  @Override
  public Book findBookById(long id) {
    return bookRepository.findBookById(id);
  }

  @Override
  public void updateBook(Book book) {
    bookRepository.updateBook(book);
  }

  @Override
  public void insertBook(Book book) {
    bookRepository.insertBook(book);
  }

  @Override
  public void updateOutStockBook(Book book) {
    bookRepository.updateOutStockBook(book);
  }

}
