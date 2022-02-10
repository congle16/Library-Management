package com.team4.lib.model.mapper.repository;

import java.util.List;

import com.team4.lib.domain.BorrowOrder;
import org.apache.ibatis.session.SqlSession;
import com.team4.lib.model.BorrowBookDto;
import com.team4.lib.model.mapper.BorrowOrderModelMapper;
import com.team4.lib.mybaties.activemodel.Repository;

@org.springframework.stereotype.Repository
public class BorrowOrderRepository extends Repository<BorrowOrderModelMapper> {

  @Override
  protected BorrowOrderModelMapper repositoryMapper(SqlSession session) {
    return session.getMapper(BorrowOrderModelMapper.class);
  }

  public void insertBorrowOrder(BorrowOrder borrowOrder) {
    execute(mapper -> {
      mapper.insertBorrowOrder(borrowOrder);
    });
  }

  public List<BorrowOrder> getListBorrowOrder() {
    return execute(mapper -> {
      return mapper.getListBorrowOrder();
    });
  }

  public List<BorrowOrder> getListBorrowOrderByUser(Long id) {
    return execute(mapper -> {
      return mapper.getListBorrowOrderByUser(id);
    });
  }

  public BorrowBookDto findBorrowOrderBookById(Long id) {
    return execute(mapper -> {
      return mapper.findBorrowOrderBookById(id);
    });
  }

  public void updateStatusBorrowOrder(BorrowOrder borrowOrder) {
    execute(mapper -> {
      mapper.updateStatusBorrowOrder(borrowOrder);
    });
  }

  public BorrowOrder findBorrowOrderById(Long id) {
    return execute(mapper -> {
      return mapper.findBorrowOrderById(id);
    });
  }

  public Long countBorrowOrderByUser(Long id) {
    return execute(mapper -> {
      return mapper.countBorrowOrderByUser(id);
    });
  }

}
