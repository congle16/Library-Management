package com.team4.lib.model.mapper;

import java.util.List;
import com.team4.lib.domain.Category;

public interface CategoryModelMapper {

  List<Category> getListCategory();

  void insertCategory(Category category);

  Category findCategoryById(long id);

  void updateCategory(Category category);

  void deleteCategory(long id);

  Long checkCategoryValid(Long id);
}
