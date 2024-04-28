package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthDAO {
    private Connection connection;
    private List<Integer> ids;

    public AuthDAO(Connection connection){
        this.connection = connection;
        ids = new ArrayList<>();
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
            this.ids.add(id);
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
        //if(auth.getId() > this.lastId){
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO Authors (AID, AuthName) VALUES (?, ?)");
            statement.setInt(1, auth.getId());
            statement.setString(2, auth.getName());
            statement.executeUpdate();
            //this.lastId++;
        //}

        //else System.out.println("Deja exista un autor cu acest id");
    }

    public void updateAuth(int id, String name) throws SQLException {
        //if(id <= this.lastId){
            PreparedStatement statement = this.connection.prepareStatement("UPDATE Authors SET AuthName = ? WHERE AID = ?");
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        //}

        //else System.out.println("Nu exista niciun autor cu acest id.");
    }

    public void deleteAuth(int id) throws SQLException {
        //if(id <= this.lastId){
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM Authors WHERE AID = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        //    this.lastId--;
       // }

        //else System.out.println("Nu exista niciun autor cu acest id.");
    }

    public int getLastId(){
        //return this.lastId;
        return 1;
    }
}
