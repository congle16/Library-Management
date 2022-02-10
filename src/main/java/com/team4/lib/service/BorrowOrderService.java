package com.team4.lib.service;

import java.util.List;

import com.team4.lib.dao.BorrowOrderDao;
import com.team4.lib.domain.BorrowOrder;
import com.team4.lib.model.BorrowBookDto;
import com.team4.lib.model.mapper.repository.BorrowOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowOrderService implements BorrowOrderDao {

  @Autowired
  BorrowOrderRepository borrowOrderRepository;

  @Override
  public void insertBorrowOrder(BorrowOrder borrowOrder) {
    borrowOrderRepository.insertBorrowOrder(borrowOrder);
  }

  @Override
  public List<BorrowOrder> getListBorrowOrder() {
    return borrowOrderRepository.getListBorrowOrder();
  }

  @Override
  public List<BorrowOrder> getListBorrowOrderByUser(Long id) {
    return borrowOrderRepository.getListBorrowOrderByUser(id);
  }

  @Override
  public BorrowBookDto findBorrowOrderBookById(Long id) {
    return borrowOrderRepository.findBorrowOrderBookById(id);
  }

  @Override
  public void updateStatusBorrowOrder(BorrowOrder borrowOrder) {
    borrowOrderRepository.updateStatusBorrowOrder(borrowOrder);
  }

  @Override
  public BorrowOrder findBorrowOrderById(Long id) {
    return borrowOrderRepository.findBorrowOrderById(id);
  }

  @Override
  public Long countBorrowOrderByUser(Long id) {
    return borrowOrderRepository.countBorrowOrderByUser(id);
  }

}
