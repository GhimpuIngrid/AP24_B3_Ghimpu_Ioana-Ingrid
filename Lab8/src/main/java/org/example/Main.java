package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection conn = ConnPool.getConnection();
        if (conn != null)
            System.out.println("Am facut conexiunea");
        else
            System.out.println("Nu am facut conexiunea");

        AuthDAO authDAO = new AuthDAO(conn);

        Auth auth1 = new Auth(4, "Andrzej Sapkowski");
        //authDAO.addAuth(auth1);

        //authDAO.updateAuth(4, "H.P. Lovecraft");

        //authDAO.deleteAuth(4);

        List<Auth> authors = new ArrayList<>();
        authors = authDAO.getAuth();

        for(Auth auth: authors){
            //System.out.println(auth);
        }

        GenreDAO genreDAO = new GenreDAO(conn);

        Genre genre = new Genre(4, "Thriller");

        //genreDAO.addGenre(genre);

        //genreDAO.updateGenres(4, "Romance");

        //genreDAO.deleteGenre(4);

        List<Genre> genres = genreDAO.getGenres();

        for(Genre gen: genres){
            //System.out.println(gen);
        }

        BooksDAO booksDAO = new BooksDAO(conn);

        Book book1 = new Book(4, "AA", 2, 2, 1990, 100);
        //booksDAO.addBook(book1);

        //booksDAO.updateBookTitle(4, "BB");

        //booksDAO.deleteBook(4);

        List<Book> books = booksDAO.getBooks();

        for(Book book : books){
            //System.out.println(book);
        }

        NewData newData = new NewData();
        newData.readData();

    }
}