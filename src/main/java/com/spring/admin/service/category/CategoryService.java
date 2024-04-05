package com.spring.admin.service.category;

import com.spring.admin.entity.Category;
import com.spring.admin.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    List<Category>getAll();
    Boolean create(Category category);
    Category findById(Integer id);
    Boolean update(Category category);
    Boolean delete(Integer id);
    List<Category>searchCategory(String keyword);
    Page<Category>page(Integer pageNo);
    Set<Product> getByCategory(Category category);
}
