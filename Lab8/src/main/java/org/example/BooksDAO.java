package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO {
    private Connection connection;

    public BooksDAO(Connection conn){
        this.connection = conn;
    }

    public List<Book> getBooks() throws SQLException {
        List<Book> books = new ArrayList<>();

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");

        while(resultSet.next()){
            int id = resultSet.getInt("BookID");
            String title = resultSet.getString("Title");
            int authId = resultSet.getInt("AID");
            int genId = resultSet.getInt("GID");
            Date year = resultSet.getDate("PublicationYear");
            int numPag = resultSet.getInt("Pages");

            Book book = new Book(id, title, authId, genId, year, numPag);
            books.add(book);
        }

        return books;
    }
}
