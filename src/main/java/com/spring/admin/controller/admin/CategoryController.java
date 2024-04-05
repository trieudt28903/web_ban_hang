package com.spring.admin.controller.admin;

import com.spring.admin.entity.Category;
import com.spring.admin.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public String index(Model model,@Param("keyword") String keyword,@RequestParam(name = "pageNo",defaultValue = "1")Integer pageNo){

        Page<Category> categoryList=categoryService.page(pageNo);

        model.addAttribute("list",categoryList);
        model.addAttribute("totalPage",categoryList.getTotalPages());
        model.addAttribute("currentPage",pageNo);

        return "admin/category/index";
    }
    @GetMapping("/add-category")
    public String add(Model model){
        Category category=new Category();
        model.addAttribute("category",category);
        return "admin/category/add";
    }
    @PostMapping("/add-category")
    public String create(@ModelAttribute("category") Category category){
        if(categoryService.create(category)){
            return "redirect:/admin/category";
        }
        else {
            return "admin/category/add";
        }
    }
    @GetMapping("/edit-category/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);
        return "admin/category/edit";
    }
    @PostMapping("/edit-category")
    public String update(@ModelAttribute("category") Category category){
        if(categoryService.create(category)){
            return "redirect:/admin/category";
        }
        else {
            return "admin/category/edit";
        }
    }
    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(categoryService.delete(id)){
            return "redirect:/admin/category";
        }
        else {
            return "admin/category/add";
        }
    }

}
