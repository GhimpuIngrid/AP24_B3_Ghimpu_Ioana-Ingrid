package com.example.Lab11;

import com.example.Lab11.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    public List<Author> getAuthors() throws SQLException {
        return this.authorsService.getAllAuthors();
    }
}
