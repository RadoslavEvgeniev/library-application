package org.rado.bookapi.db.repository.impl;

import org.rado.bookapi.db.entity.Book;
import org.rado.bookapi.db.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository<Book, Long> {

    private Map<Long, Book> database = new LinkedHashMap<>();

    @Override
    public List<Book> findAll() {
        return (List<Book>) this.database.values();
    }

    @Override
    public Book findById(Long id) {
        return this.database.get(id);
    }

    @Override
    public Book create(Book book) {
        book.setId(Long.valueOf(String.valueOf(this.database.size())));

        return this.database.put(book.getId(), book);
    }


}
