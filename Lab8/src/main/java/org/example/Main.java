package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DB.getConnection();
        if (conn != null)
            System.out.println("Am facut conexiunea");
        else
            System.out.println("Nu am facut conexiunea");

        AuthDAO authDAO = new AuthDAO(conn);

        Auth auth1 = new Auth(4, "Andrzej Sapkowski");
        authDAO.addAuth(auth1);

        List<Auth> authors = new ArrayList<>();
        authors = authDAO.getAuth();

        for(Auth auth: authors){
            System.out.println(auth);
        }

        authDAO.updateAuth(4, "H.P. Lovecraft");

        List<Auth> updatedAuthors = new ArrayList<>();
        updatedAuthors = authDAO.getAuth();

        for(Auth auth: updatedAuthors){
            System.out.println(auth);
        }

        authDAO.deleteAuth(4);

        List<Auth> deletedAuthors = new ArrayList<>();
        deletedAuthors = authDAO.getAuth();

        for(Auth auth: deletedAuthors){
            System.out.println(auth);
        }
    }
}