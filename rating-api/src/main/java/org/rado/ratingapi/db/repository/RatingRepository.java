package org.rado.ratingapi.db.repository;

import org.rado.ratingapi.db.entity.Rating;

import java.util.List;

public interface RatingRepository<ENTITY, ID> {

    List<ENTITY> findAll();

    List<ENTITY> findByAllBookId(ID bookId);

    ENTITY create(ENTITY entity);
}
