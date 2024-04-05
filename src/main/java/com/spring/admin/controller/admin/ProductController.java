package com.spring.admin.controller.admin;


import com.spring.admin.entity.Category;
import com.spring.admin.entity.Product;
import com.spring.admin.service.StorageService;
import com.spring.admin.service.category.CategoryService;
import com.spring.admin.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    StorageService storageService;

    @GetMapping("/product")
    public String index(Model model) {
        List<Product>products=this.productService.getAll();
        model.addAttribute("products",products);
        return "admin/product/index";
    }

    @GetMapping("/product-add") // Sửa từ @RequestMapping sang @GetMapping để phù hợp với việc thêm mới sản phẩm
    public String add(Model model) {
        Product product=new Product();
        model.addAttribute("product", product);
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/product/add";
    }

    @PostMapping("/product-add")
    public String create(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                this.storageService.store(file);
                String fileName = file.getOriginalFilename();
                product.setImage(fileName);
            } catch (Exception e) {
                e.printStackTrace(); // Xử lý lỗi nếu có
            }
        }
        if (productService.create(product)) {
            return "redirect:/admin/product";
        }
        return "redirect:/admin/product-add";
    }
    @GetMapping("product-edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Product product=productService.findById(id);
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("product",product);
        model.addAttribute("categoryList", categoryList);
        return "admin/product/edit";
    }
    @PostMapping("product-edit")
    public String update(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                this.storageService.store(file);
                String fileName = file.getOriginalFilename();
                product.setImage(fileName);
            } catch (Exception e) {
                e.printStackTrace(); // Xử lý lỗi nếu có
            }
        }
        if (productService.create(product)) {
            return "redirect:/admin/product";
        }
        return "redirect:/admin/product-add";
    }


}
