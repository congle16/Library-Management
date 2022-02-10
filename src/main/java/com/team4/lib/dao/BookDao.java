package com.team4.lib.dao;

import java.util.List;
import com.team4.lib.domain.Book;

public interface BookDao {

  List<Book> getListBook();

  Book findBookById(long id);

  void updateBook(Book book);

  void insertBook(Book book);

  void updateOutStockBook(Book book);
}
