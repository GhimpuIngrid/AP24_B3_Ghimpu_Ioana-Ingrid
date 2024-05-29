package com.example.Lab11;

import com.example.Lab11.entities.Author;
import com.example.Lab11.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() throws SQLException {
        return ResponseEntity.ok()
                .body(bookService.getAllBooks());
    }

    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBookById(@PathVariable("book-id") int id) throws SQLException {
        if(id<0){
            return ResponseEntity.badRequest().build();
        }

        else{
            if(bookService.getById(id)==null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok()
                    .body(bookService.getById(id));
        }
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws SQLException {
        if(book == null || book.getTitle() == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.status(201).body(bookService.createBook(book));
    }

    @PutMapping("/{book-id}")
    public ResponseEntity<Book> modifyAuthName(@PathVariable("book-id") int id, @RequestBody Author auth) throws SQLException {
        if(id < 0 || auth.getId() < 0)
            return ResponseEntity.badRequest().build();
        else{
            if(bookService.getById(id)==null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok()
                    .body(bookService.updateBook(id, auth.getId()));
        }
    }

    @DeleteMapping("/{book-id}")
    public ResponseEntity deleteBook(@PathVariable("book-id") int id) throws SQLException {
        if(id < 0)
            return ResponseEntity.badRequest().build();
        else if(bookService.getById(id) == null)
            return ResponseEntity.notFound().build();
        else {
            bookService.delete(id);
            return ResponseEntity.ok().build();
        }
    }

}
