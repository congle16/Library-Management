package com.team4.lib.model.mapper;

import java.util.List;
import com.team4.lib.domain.BorrowOrder;
import com.team4.lib.model.BorrowBookDto;

public interface BorrowOrderModelMapper {

  void insertBorrowOrder(BorrowOrder borrowOrder);

  List<BorrowOrder> getListBorrowOrder();

  List<BorrowOrder> getListBorrowOrderByUser(Long id);

  BorrowBookDto findBorrowOrderBookById(Long id);

  void updateStatusBorrowOrder(BorrowOrder borrowOrder);

  BorrowOrder findBorrowOrderById(Long id);

  Long countBorrowOrderByUser(Long id);
}
