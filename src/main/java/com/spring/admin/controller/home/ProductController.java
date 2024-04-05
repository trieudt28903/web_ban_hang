package com.spring.admin.controller.home;

import com.spring.admin.entity.Category;
import com.spring.admin.entity.Product;
import com.spring.admin.service.category.CategoryService;
import com.spring.admin.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller("homeProductController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index(Model model) {
        List<Category> categoryList = categoryService.getAll();

        for (Category category : categoryList) {
            Set<Product> productList = categoryService.getByCategory(category);
            category.setProducts(productList);
        }

        model.addAttribute("categoryList", categoryList);
        return "home/index";
    }
    @GetMapping("/product")
    public String Seemore(@RequestParam("id")Integer id,Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);

        return "home/see-more";
    }
}
