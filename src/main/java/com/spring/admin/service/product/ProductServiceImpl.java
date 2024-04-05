package com.spring.admin.service.product;

import com.spring.admin.entity.Product;
import com.spring.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;
    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Boolean create(Product product) {
        try {
            repository.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Boolean update(Product product) {
        try {
            repository.save(product);
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
