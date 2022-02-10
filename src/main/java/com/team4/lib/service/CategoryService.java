package com.team4.lib.service;

import java.util.List;

import com.team4.lib.dao.CategoryDao;
import com.team4.lib.domain.Category;
import com.team4.lib.model.mapper.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CategoryDao {

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public List<Category> getListCategory() {
    return categoryRepository.getListCategory();
  }

  @Override
  public void insertCategory(Category category) {
    categoryRepository.insertCategory(category);
  }

  @Override
  public Category findCategoryById(long id) {
    return categoryRepository.findCategoryById(id);
  }

  @Override
  public void updateCategory(Category category) {
    categoryRepository.updateCategory(category);
  }

  @Override
  public void deleteCategory(long id) {
    categoryRepository.deleteCategory(id);
  }

  @Override
  public boolean checkCategoryValid(Long id) {
    boolean isCheck = false;
    Long result = categoryRepository.checkCategoryValid(id);
    if (result != 0) {
      isCheck = true;
      return isCheck;
    }
    return isCheck;
  }

}
