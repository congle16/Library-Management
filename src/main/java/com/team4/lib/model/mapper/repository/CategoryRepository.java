package com.team4.lib.model.mapper.repository;

import java.util.List;

import com.team4.lib.domain.Category;
import org.apache.ibatis.session.SqlSession;
import com.team4.lib.model.mapper.CategoryModelMapper;
import com.team4.lib.mybaties.activemodel.Repository;

@org.springframework.stereotype.Repository
public class CategoryRepository extends Repository<CategoryModelMapper> {

  @Override
  protected CategoryModelMapper repositoryMapper(SqlSession session) {
    return session.getMapper(CategoryModelMapper.class);
  }

  public List<Category> getListCategory() {
    return execute(mapper -> {
      return mapper.getListCategory();
    });
  }

  public void insertCategory(Category category) {
    execute(mapper -> {
      mapper.insertCategory(category);
    });
  }

  public Category findCategoryById(long id) {
    return execute(mapper -> {
      return mapper.findCategoryById(id);
    });
  }

  public void updateCategory(Category category) {
    execute(mapper -> {
      mapper.updateCategory(category);
    });
  }

  public void deleteCategory(long id) {
    execute(mapper -> {
      mapper.deleteCategory(id);
    });
  }

  public Long checkCategoryValid(Long id) {
    return execute(mapper -> {
      return mapper.checkCategoryValid(id);
    });
  }

}
