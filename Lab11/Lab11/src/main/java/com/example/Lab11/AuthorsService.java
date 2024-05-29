package com.example.Lab11;

import com.example.Lab11.Repositories.AuthorRepository;
import com.example.Lab11.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorsService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorsService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authorList = new ArrayList<>();
        authorList = this.authorRepository.findAll();
        return authorList;
    }
}
