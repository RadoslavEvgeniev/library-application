package org.rado.ratingapi.db.repository.impl;

import org.rado.ratingapi.db.entity.Rating;
import org.rado.ratingapi.db.repository.RatingRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RatingRepositoryImpl implements RatingRepository<Rating, Long> {

    private Map<Long, Rating> database = new LinkedHashMap<>();

    @Override
    public List<Rating> findAll() {
        return (List<Rating>) this.database.values();
    }

    @Override
    public List<Rating> findByAllBookId(Long bookId) {
        return this.database.values().stream().filter(book -> book.getBookId().equals(bookId)).collect(Collectors.toList());
    }

    @Override
    public Rating create(Rating rating) {
        rating.setId(Long.valueOf(String.valueOf(this.database.size())));
        return this.database.put(rating.getId(), rating);
    }
}
