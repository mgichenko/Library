package com.example.Library.controllers;

import com.example.Library.pojo.Category;
import com.example.Library.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    /**
     * @return list of categories
     */

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    /**
     * @return list of categories ordered by their name
     */

    @GetMapping("/ordered")
    public List<Category> findOrdered() {
        return categoryService.findOrdered();
    }
}
