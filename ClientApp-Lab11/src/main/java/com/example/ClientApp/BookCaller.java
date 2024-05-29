package com.example.ClientApp;

import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client/books")
public class BookCaller {
    String uri = "http://localhost:5050/api/v1/books";

    @GetMapping
    public List<Book> getBooks() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Book>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Book>>(){});
        List<Book> result = response.getBody();

        return result;
    }

    @GetMapping("/{id-book}")
    public Book getById(@PathVariable("book-id") int id){
        RestTemplate restTemplate = new RestTemplate();
        uri = this.uri + "/" + id;
        ResponseEntity<Book> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<Book>(){}
        );

        Book result = response.getBody();
        return result;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Book> request = new HttpEntity<>(book);
        ResponseEntity<Book> response = restTemplate.exchange(
                uri, HttpMethod.POST, request,
                new ParameterizedTypeReference<Book>() {}
        );

        return response.getBody();
    }

    @PutMapping("/{book-id}")
    public Book updateBook(@PathVariable("book-id") int id, @RequestBody Author author){
        RestTemplate restTemplate = new RestTemplate();
        uri = this.uri + "/" + id;
        HttpEntity<Author> request = new HttpEntity<>(author);
        ResponseEntity<Book> response = restTemplate.exchange(
                uri, HttpMethod.PUT, request,
                new ParameterizedTypeReference<Book>() {}
        );
        return response.getBody();
    }

    @DeleteMapping("/{book-id}")
    public void deleteBook(@PathVariable("book-id") int id){
        RestTemplate restTemplate = new RestTemplate();
        uri = this.uri + "/" + id;
        restTemplate.exchange(uri, HttpMethod.DELETE, null, Void.class);
    }

}
