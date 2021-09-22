package org.rado.bookapi.db.repository;

import org.rado.bookapi.db.entity.Book;

import java.util.List;

public interface BookRepository<ENTITY, ID> {

    List<ENTITY> findAll();

    ENTITY findById(ID id);

    ENTITY create(ENTITY entity);
}
