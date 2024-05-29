package com.example.Lab11;

import com.example.Lab11.Repositories.BookRepository;
import com.example.Lab11.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        books = this.bookRepository.findAll();
        return books;
    }

    public Book getById(int id) throws SQLException {
        Book book = this.bookRepository.findById(id);
        return book;
    }

    public Book createBook(Book book) throws SQLException {
        Book createdBook = this.bookRepository.add(book);
        return createdBook;
    }

    public Book updateBook(int id, int aid) throws SQLException {
        Book updatedBook = this.bookRepository.updateBookAuthor(id, aid);
        return updatedBook;
    }

    public void delete(int id) throws SQLException {
        this.bookRepository.deleteBook(id);
    }
}
