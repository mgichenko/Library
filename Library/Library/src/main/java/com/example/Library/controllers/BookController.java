package com.example.Library.controllers;

import com.example.Library.pojo.Category;
import com.example.Library.services.BookService;
import com.example.Library.services.CategoryService;
import org.springframework.web.bind.annotation.*;
import com.example.Library.pojo.Book;
import com.example.Library.pojo.BookInput;


import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    private CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    /**
     * @return list of books
     */

    @GetMapping
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    /**
     * @param category of a book
     * @return list of books that belong to the category
     */

    @GetMapping("/{category}")
    public List<Book> getByCategory(@RequestBody Category category) {
        return bookService.findByCategory(category);
    }

    /**
     * @param id of a book
     * @return book with the id or null if none is present
     */

    @GetMapping("/{id}")
    public Book findBook(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    /**
     * @param bookInput model of the request
     * @return created book
     */

    @PostMapping
    public Book createBook(@RequestBody BookInput bookInput) {
        return bookService.create(bookInput);
    }

    /**
     * @param id of the book
     * @return true if the book is deleted, false if not
     */

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable Integer id) {
        return bookService.deleteById(id);
    }
}