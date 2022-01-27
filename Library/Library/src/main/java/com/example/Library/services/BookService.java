package com.example.Library.services;

import com.example.Library.pojo.Book;
import com.example.Library.pojo.BookInput;
import com.example.Library.pojo.Category;
import com.example.Library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Integer id) {
        return bookRepository.findBookById(id);
    }

    public boolean deleteById(Integer id) {
        Book book = bookRepository.findBookById(id);
        if (book != null) {
            bookRepository.delete(book);
        }
        return true;
    }

    public Book create(BookInput bookInput) {
        String newTitle = bookInput.getTitle();
        String newAuthor = bookInput.getAuthor();
        String newPublisher = bookInput.getPublisher();

        Book book = new Book();
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setPublisher(newPublisher);

        return bookRepository.save(book);
    }

    public List<Book> findByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

}
