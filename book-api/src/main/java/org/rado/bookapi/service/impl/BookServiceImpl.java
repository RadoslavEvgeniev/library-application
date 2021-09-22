package org.rado.bookapi.service.impl;

import org.rado.bookapi.db.entity.Book;
import org.rado.bookapi.db.repository.BookRepository;
import org.rado.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository<Book, Long> bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository<Book, Long> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book) {
        return this.bookRepository.create(book);
    }
}
