package com.spring.admin.repository;

import com.spring.admin.entity.Category;
import com.spring.admin.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Set<Product> findByCategory(Category category);
}
