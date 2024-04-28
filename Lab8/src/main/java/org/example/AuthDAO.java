package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthDAO {
    private Connection connection;

    public AuthDAO(Connection connection){
        this.connection = connection;
    }

    public List<Auth> getAuth() throws SQLException{
        List<Auth> authors = new ArrayList();

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Authors");

        while(resultSet.next()){
            int id = resultSet.getInt("AID");
            String name = resultSet.getString("AuthName");
            Auth author = new Auth(id, name);
            authors.add(author);
        }

        return authors;
    }

    public Auth getAuthById(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM Authors WHERE AID = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next()){
            String name = resultSet.getString("AuthName");
            return new Auth(id, name);
        }

        return null;
    }

    public void addAuth(Auth auth) throws SQLException{
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Authors (AID, AuthName) VALUES (?, ?)");
        statement.setInt(1, auth.getId());
        statement.setString(2, auth.getName());
        statement.executeUpdate();

    }

    public void updateAuth(int id, String name) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("UPDATE Authors SET AuthName = ? WHERE id = ?");
        statement.setString(1, name);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    public void deleteAuth(int id) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Authors WHERE AID = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}
