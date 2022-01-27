package com.example.Library.repositories;

import com.example.Library.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Library.pojo.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAll();
    List<Book> findByCategory(Category category);
    Book findBookById(Integer id);

}
