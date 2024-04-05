package com.spring.admin.service.category;

import com.spring.admin.entity.Category;
import com.spring.admin.entity.Product;
import com.spring.admin.repository.CategoryRepository;
import com.spring.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceIImpl implements CategoryService {
    @Autowired
    CategoryRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try {
            repository.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Category findById(Integer id) {
        return repository.findById(id).get();
    }


    @Override
    public Boolean update(Category category) {
        try {
            this.repository.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            repository.delete(findById(id));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> searchCategory(String keyword) {

        return this.repository.searchCategory(keyword);
    }

    @Override
    public Page<Category> page(Integer pageNo) {
        Pageable pageable= PageRequest.of(pageNo-1,2);
        return this.repository.findAll(pageable);
    }

    @Override
    public Set<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category);
    }


}
