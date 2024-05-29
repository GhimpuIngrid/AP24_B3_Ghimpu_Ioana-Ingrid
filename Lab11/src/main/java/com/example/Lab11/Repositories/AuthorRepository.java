package com.example.Lab11.Repositories;

import com.example.Lab11.DBConnection;
import com.example.Lab11.entities.Author;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {


    public List<Author> findAll() throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<Author> authors = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Authors");

        while(resultSet.next()){
            int id = resultSet.getInt("AID");
            String name = resultSet.getString("AuthName");
            Author author = new Author(id, name);
            authors.add(author);
        }

        return authors;
    }
}
