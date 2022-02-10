package com.team4.lib.dao;

import java.util.List;
import com.team4.lib.domain.Category;

public interface CategoryDao {
  List<Category> getListCategory();

  void insertCategory(Category category);

  Category findCategoryById(long id);

  void updateCategory(Category category);

  void deleteCategory(long id);

  boolean checkCategoryValid(Long id);
}
