package org.example;

import java.sql.*;
import java.time.LocalDate;
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
            int year = resultSet.getInt("PublicationYear");
            int numPag = resultSet.getInt("Pages");

            Book book = new Book(id, title, authId, genId, year, numPag);
            books.add(book);
        }

        return books;
    }

    public Book getBookById(int id) throws SQLException{
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

    public void addBook(Book book) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Books (BookID, Title, AID, GID, PublicationYear, Pages) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setInt(1, book.getId());
        statement.setString(2, book.getTitle());
        statement.setString(3, String.valueOf(book.getAuthId()));
        statement.setString(4, String.valueOf(book.getGenId()));
        statement.setString(5, String.valueOf(book.getDate()));
        statement.setString(6, String.valueOf(book.getNumberOfPages()));
        statement.executeUpdate();
    }

    public void updateBookTitle(int id, String title) throws SQLException{
        PreparedStatement statement = this.connection.prepareStatement("UPDATE Books SET Title = ? WHERE BookID = ?");
        statement.setString(1, title);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    public void deleteBook(int id) throws SQLException{
        PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Books WHERE BookID = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
