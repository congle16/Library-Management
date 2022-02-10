package com.team4.lib.model.mapper.repository;

import java.util.List;

import com.team4.lib.domain.Book;
import org.apache.ibatis.session.SqlSession;
import com.team4.lib.model.mapper.BookModelMapper;
import com.team4.lib.mybaties.activemodel.Repository;

@org.springframework.stereotype.Repository
public class BookRepository extends Repository<BookModelMapper> {

  @Override
  protected BookModelMapper repositoryMapper(SqlSession session) {
    return session.getMapper(BookModelMapper.class);
  }

  public List<Book> getListBook() {
    return execute(mapper -> {
      return mapper.getListBook();
    });
  }

  public Book findBookById(long id) {
    return execute(mapper -> {
      return mapper.findBookById(id);
    });
  }

  public void updateBook(Book book) {
    execute(mapper -> {
      mapper.updateBook(book);
    });
  }

  public void insertBook(Book book) {
    execute(mapper -> {
      mapper.insertBook(book);
    });
  }

  public void updateOutStockBook(Book book) {
    execute(mapper -> {
      mapper.updateOutStockBook(book);
    });
  }
}
