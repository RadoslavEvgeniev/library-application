package org.rado.bookapi.service;

import org.rado.bookapi.db.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();

    Book findBookById(Long id);

    Book createBook(Book book);
}
