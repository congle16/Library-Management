package com.team4.lib.controller;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.team4.lib.dao.BookDao;
import com.team4.lib.dao.BorrowOrderDao;
import com.team4.lib.dao.CategoryDao;
import com.team4.lib.domain.Book;
import com.team4.lib.domain.BorrowOrder;
import com.team4.lib.domain.Category;
import com.team4.lib.model.BorrowBookDto;
import com.team4.lib.model.UserModel;
import com.team4.lib.utils.MessageUltils;
import com.team4.lib.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(path = "/book")
@SessionAttributes(names = {"user", "listBorrowOrder"})
public class BookController {

  @Autowired
  BookDao bookDao;

  @Autowired
  CategoryDao categoryDao;

  @Autowired
  BorrowOrderDao borrowOrderDao;

  @GetMapping(path = "/xem-noi-dung/{id}")
  public String redirectDetailBook(@PathVariable long id, Model model) {
    Book book = bookDao.findBookById(id);
    model.addAttribute("book", book);
    return "/book/detail-book";
  }

  @GetMapping(path = "/admin/cap-nhat-sach/{id}")
  public String redirectUpdateBookPage(@PathVariable long id, Model model) {
    Book book = bookDao.findBookById(id);
    List<Category> listCategory = categoryDao.getListCategory();
    model.addAttribute("book", book);
    model.addAttribute("listCategory", listCategory);
    return "/book/update-book";
  }

  @PostMapping(path = "/admin/cap-nhat-sach")
  public String redirectUpdateBookPage(@SessionAttribute UserModel user, @ModelAttribute Book book,
                                       Model model) {
    try {
      book.setUpdateTime(StringUtils.getTimestampNow());
      book.setUpdateUser(user.getUsername());
      bookDao.updateBook(book);
    } catch (Exception e) {
      return "redirect:/403";
    }
    return "redirect:/home";
  }

  @PostMapping(path = "/admin/them-moi-sach")
  public String handleInsertBook(@SessionAttribute UserModel user, @ModelAttribute Book book,
      Model model) {
    try {
      book.setCreateTime(StringUtils.getTimestampNow());
      book.setCreateUser(user.getUsername());
      book.setUpdateTime(StringUtils.getTimestampNow());
      book.setUpdateUser(user.getUsername());
      bookDao.insertBook(book);
    } catch (Exception e) {
      return "redirect:/403";
    }
    return "redirect:/home";
  }

  @GetMapping(path = "/the-loai-sach")
  public String redirectCategoryPage(Model model) {
    model.addAttribute("listCategory", categoryDao.getListCategory());
    model.addAttribute("category", new Category());
    return "/category/category-list";
  }

  @PostMapping(path = "/admin/them-the-loai-sach")
  public String handleInsertCategory(@SessionAttribute UserModel user,
      @ModelAttribute @Valid Category category, BindingResult result, Model model) {
    if (result.hasErrors()) {
      //return "/category/category-list";
      return "redirect:/book/the-loai-sach";
    }
    try {
      category.setCreateTime(StringUtils.getTimestampNow());
      category.setCreateUser(user.getUsername());
      category.setUpdateTime(StringUtils.getTimestampNow());
      category.setUpdateUser(user.getUsername());
      categoryDao.insertCategory(category);
    } catch (Exception e) {
      return "redirect:/403";
    }
    return "redirect:/book/the-loai-sach";
  }

  @GetMapping(path = "/admin/{id}/cap-nhat-the-loai-sach")
  public String redirectUpdateCategoryPage(@PathVariable long id, Model model) {
    Category category = categoryDao.findCategoryById(id);
    model.addAttribute("category", category);
    return "/category/update-category";
  }

  @PostMapping(path = "/admin/cap-nhat-the-loai-sach")
  public String handleUpdateCategory(@SessionAttribute UserModel user,
      @ModelAttribute Category category, Model model) {
    try {
      category.setUpdateTime(StringUtils.getTimestampNow());
      category.setUpdateUser(user.getUsername());
      categoryDao.updateCategory(category);
    } catch (Exception e) {
      return "redirect:/403";
    }
    return "redirect:/book/the-loai-sach";
  }

  @PostMapping(path = "/admin/delete")
  public String handleDeleteCategory(@RequestParam long id, Model model) {
    boolean isCheck = categoryDao.checkCategoryValid(id);
    try {
      if (!isCheck) {
        categoryDao.deleteCategory(id);
      } else {
        model.addAttribute("error", MessageUltils.ERROR_DELETE_CATEGORY);
        model.addAttribute("listCategory", categoryDao.getListCategory());
        return "/category/category-list";
      }
    } catch (Exception e) {
      return "redirect:/403";
    }
    return "redirect:/book/the-loai-sach";
  }

  @PostMapping(path = "/borrow")
  public String handleBorrowOrderBook(@SessionAttribute UserModel user,
                                      @ModelAttribute @Valid BorrowOrder borrowOrder, BindingResult bindingResult, Model model,
                                      HttpServletRequest request) {

    List<Book> listBook = bookDao.getListBook();
    List<Category> listCategory = categoryDao.getListCategory();

    if (bindingResult.hasErrors()) {
      model.addAttribute("error", MessageUltils.DATE_ERROR);
      model.addAttribute("listBook", listBook);
      model.addAttribute("listCategory", listCategory);
      return "home";
    }
    if (borrowOrder.getBorrowDate() != null && borrowOrder.getReturnDate() != null) {
      if (StringUtils.daysBetween2Dates(borrowOrder.getBorrowDate(),
          borrowOrder.getReturnDate()) > 30) {
        model.addAttribute("error", MessageUltils.DATE_EXPIRED);
        model.addAttribute("listBook", listBook);
        model.addAttribute("listCategory", listCategory);
        return "home";
      }
    } else {
      model.addAttribute("error", MessageUltils.DATE_ERROR);
      model.addAttribute("listBook", listBook);
      model.addAttribute("listCategory", listCategory);
      return "home";
    }
    Long totalBookBorrow = borrowOrderDao.countBorrowOrderByUser((long) user.getId());
    if (user.getRole() == 0 && totalBookBorrow >= 5) {
      model.addAttribute("error", MessageUltils.BOOK_BORROW_LIMIT);
      model.addAttribute("listBook", listBook);
      model.addAttribute("listCategory", listCategory);
      return "home";
    } else if (user.getRole() == 1 && totalBookBorrow >= 10) {
      model.addAttribute("error", MessageUltils.BOOK_BORROW_LIMIT);
      model.addAttribute("listBook", listBook);
      model.addAttribute("listCategory", listCategory);
      return "home";
    } else if (user.getRole() == 1 && totalBookBorrow >= 15) {
      model.addAttribute("error", MessageUltils.BOOK_BORROW_LIMIT);
      model.addAttribute("listBook", listBook);
      model.addAttribute("listCategory", listCategory);
      return "home";
    }
    Book book = bookDao.findBookById(borrowOrder.getIdBook());
    if (book.getStock() <= book.getOutStock()) {
      model.addAttribute("error", MessageUltils.BOOK_NOT_ENOUGHT);
      model.addAttribute("listBook", listBook);
      model.addAttribute("listCategory", listCategory);
      return "home";
    }
    try {
      borrowOrder.setIdUser((long) user.getId());
      borrowOrder.setCreateTime(StringUtils.getTimestampNow());
      borrowOrder.setCreateUser(user.getUsername());
      borrowOrder.setUpdateTime(StringUtils.getTimestampNow());
      borrowOrder.setUpdateUser(user.getUsername());
      borrowOrder.setStatus(0);
      if (user.getRole() == 1) {
        borrowOrder.setStatus(1);
        book.setOutStock(book.getOutStock() + 1);
        bookDao.updateOutStockBook(book);
      }
      borrowOrderDao.insertBorrowOrder(borrowOrder);
    } catch (Exception e) {
      return "redirect:/403";
    }
    return "redirect:/home";
  }

  @GetMapping(path = "/danh-sach-muon-sach")
  public String redirectBorrowOrderPage(@SessionAttribute UserModel user, Model model) {
    List<BorrowOrder> listBorrowOrder = null;
    if (user.getRole() == 1) {
      listBorrowOrder = borrowOrderDao.getListBorrowOrder();
    } else {
      listBorrowOrder = borrowOrderDao.getListBorrowOrderByUser((long) user.getId());
    }
    model.addAttribute("listBorrowOrder", listBorrowOrder);
    return "/borrow-order/borrow-order";
  }

  @GetMapping(path = "/danh-sach-muon-sach/phe-duyet/{id}")
  public String redirectApproveBorrowOrderPage(@SessionAttribute UserModel user,
      @PathVariable Long id, Model model) {
    BorrowBookDto borrowOrder = borrowOrderDao.findBorrowOrderBookById(id);
    model.addAttribute("borrowOrderdetail", borrowOrder);
    return "/borrow-order/approve-borrow";
  }

  @PostMapping(path = "/danh-sach-muon-sach/phe-duyet")
  public String approveBorrowOrder(@SessionAttribute List<BorrowBookDto> listBorrowOrder,
      @SessionAttribute UserModel user, @RequestParam long id, Model model) throws ParseException {
    BorrowOrder borrowOrder = borrowOrderDao.findBorrowOrderById(id);
    Book book = bookDao.findBookById(borrowOrder.getIdBook());
    if (book.getStock() <= book.getOutStock()) {
      model.addAttribute("error", MessageUltils.BOOK_NOT_ENOUGHT);
      model.addAttribute("listBorrowOrder", listBorrowOrder);
      return "/borrow-order/borrow-order";
    }
    borrowOrder.setStatus(1);
    borrowOrder.setUpdateUser(user.getUsername());
    borrowOrder.setUpdateTime(StringUtils.getTimestampNow());
    borrowOrderDao.updateStatusBorrowOrder(borrowOrder);
    book.setOutStock(book.getOutStock() + 1);
    bookDao.updateOutStockBook(book);
    return "redirect:/book/danh-sach-muon-sach";
  }

  @GetMapping(path = "/danh-sach-muon-sach/tu-choi/{id}")
  public String cancleBorrowOrder(@SessionAttribute UserModel user, @PathVariable long id,
      Model model) throws ParseException {
    BorrowOrder borrowOrder = borrowOrderDao.findBorrowOrderById(id);
    borrowOrder.setStatus(2);
    borrowOrder.setUpdateUser(user.getUsername());
    borrowOrder.setUpdateTime(StringUtils.getTimestampNow());
    borrowOrderDao.updateStatusBorrowOrder(borrowOrder);
    return "redirect:/book/danh-sach-muon-sach";
  }

  @GetMapping(path = "/danh-sach-muon-sach/tra-sach/{id}")
  public String returnBorrowOrder(@SessionAttribute UserModel user, @PathVariable long id,
      Model model) throws ParseException {
    BorrowOrder borrowOrder = borrowOrderDao.findBorrowOrderById(id);
    borrowOrder.setStatus(3);
    borrowOrder.setUpdateUser(user.getUsername());
    borrowOrder.setUpdateTime(StringUtils.getTimestampNow());
    borrowOrderDao.updateStatusBorrowOrder(borrowOrder);
    Book book = bookDao.findBookById(borrowOrder.getIdBook());
    book.setOutStock(book.getOutStock() - 1);
    bookDao.updateOutStockBook(book);
    return "redirect:/book/danh-sach-muon-sach";
  }

  @GetMapping(path = "/danh-sach-muon-sach/mat-sach/{id}")
  public String missingBorrowOrder(@SessionAttribute UserModel user, @PathVariable long id,
      Model model) throws ParseException {
    BorrowOrder borrowOrder = borrowOrderDao.findBorrowOrderById(id);
    borrowOrder.setStatus(4);
    borrowOrder.setUpdateUser(user.getUsername());
    borrowOrder.setUpdateTime(StringUtils.getTimestampNow());
    borrowOrderDao.updateStatusBorrowOrder(borrowOrder);
    Book book = bookDao.findBookById(borrowOrder.getIdBook());
    book.setStock(book.getStock() - 1);
    book.setOutStock(book.getOutStock() - 1);
    bookDao.updateOutStockBook(book);
    return "redirect:/book/danh-sach-muon-sach";
  }

}
