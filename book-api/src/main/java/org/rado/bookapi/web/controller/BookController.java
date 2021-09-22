package org.rado.bookapi.web.controller;

import org.rado.bookapi.db.entity.Book;
import org.rado.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    private ResponseEntity<List<Book>> findAllBooks() {
        return new ResponseEntity<>(this.bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Book> findBookById(@PathVariable Long id) {
        return new ResponseEntity<>(this.bookService.findBookById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<Book> createBook(@RequestBody Book book) {
       return new ResponseEntity<>(this.bookService.createBook(book), HttpStatus.CREATED);
    }
}
