package org.example;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        if (conn != null)
            System.out.println("Am facut conexiunea");
        else
            System.out.println("Nu am facut conexiunea");
    }
}