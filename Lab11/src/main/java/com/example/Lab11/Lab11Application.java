package com.example.Lab11;

import com.example.Lab11.Repositories.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Lab11Application {

	public static void main(String[] args) throws SQLException {
		
		SpringApplication.run(Lab11Application.class, args);
	}

}
