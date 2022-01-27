package com.example.Library.repositories;


import com.example.Library.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByOrderByNameAsc();

    Category findNotebookById(Integer id);
    List<Category> findAll();

}

