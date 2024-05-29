package com.example.Lab11.Repositories;

import com.example.Lab11.DBConnection;
import com.example.Lab11.entities.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private Connection connection;

    public BookRepository() {
        connection = DBConnection.getConnection();
    }

    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");

        while(resultSet.next()){
            int id = resultSet.getInt("BookID");
            String title = resultSet.getString("Title");
            int authId = resultSet.getInt("AID");
            int genId = resultSet.getInt("GID");
            int year = resultSet.getInt("PublicationYear");
            int numPag = resultSet.getInt("Pages");

            Book book = new Book(id, title, authId, genId, year, numPag);
            books.add(book);
        }

        return books;
    }

    public Book findById(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Books WHERE BookID = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            String name = resultSet.getString("Title");
            int authId = resultSet.getInt("AID");
            int genId = resultSet.getInt("GID");
            int date = resultSet.getInt("PublicationYear");
            int nrPag = resultSet.getInt("Pages");
            return new Book(id, name, authId, genId, date, nrPag);
        }

        return null;
    }

    public Book add(Book book) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Books (BookID, Title, AID, GID, PublicationYear, Pages) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setInt(1, book.getId());
        statement.setString(2, book.getTitle());
        statement.setString(3, String.valueOf(book.getAuthId()));
        statement.setString(4, String.valueOf(book.getGenId()));
        statement.setString(5, String.valueOf(book.getDate()));
        statement.setString(6, String.valueOf(book.getNumberOfPages()));
        statement.executeUpdate();
        return book;
    }

    public Book updateBookAuthor(int id, int authId) throws SQLException{
        PreparedStatement statement = this.connection.prepareStatement("UPDATE Books SET AID = ? WHERE BookID = ?");
        statement.setInt(1, authId);
        statement.setInt(2, id);
        statement.executeUpdate();
        return this.findById(id);
    }

    public void deleteBook(int id) throws SQLException{
        PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Books WHERE BookID = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
