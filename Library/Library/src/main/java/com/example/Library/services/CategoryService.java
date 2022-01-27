package com.example.Library.services;

import com.example.Library.pojo.Category;
import com.example.Library.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findOrdered() {
        return categoryRepository.findAllByOrderByNameAsc();
    }
}
