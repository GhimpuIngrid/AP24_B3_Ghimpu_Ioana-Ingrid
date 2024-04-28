package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
    private Connection connection;

    public GenreDAO(Connection connection){
        this.connection = connection;
    }

    public List<Genre> getGenres() throws SQLException {
        List<Genre> genres = new ArrayList<>();
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Genres");

        while(resultSet.next()){
            int id = resultSet.getInt("GID");
            String name = resultSet.getString("GenreName");
            Genre genre = new Genre(id, name);
            genres.add(genre);
        }

        return genres;
    }

    public Genre getGenById(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Genres WHERE GID = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            String name = resultSet.getString("GenreName");
            return new Genre(id, name);
        }

        return null;
    }

    public void addGenre(Genre gen) throws SQLException{
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Genres (GID, GenreName) VALUES (?, ?)");
        statement.setInt(1, gen.getId());
        statement.setString(2, gen.getName());
        statement.executeUpdate();
    }

    public void updateGenres(int id, String name) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("UPDATE Genres SET GenreName = ? WHERE GID = ?");
        statement.setString(1, name);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    public void deleteGenre(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Genres WHERE GID = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
