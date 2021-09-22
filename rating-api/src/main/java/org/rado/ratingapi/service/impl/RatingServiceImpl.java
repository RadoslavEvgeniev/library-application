package org.rado.ratingapi.service.impl;

import org.rado.ratingapi.db.entity.Rating;
import org.rado.ratingapi.db.repository.RatingRepository;
import org.rado.ratingapi.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository<Rating, Long> ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository<Rating, Long> ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> findAllRatingsByBookId(Long bookId) {
        if (bookId.equals(0L)) {
            return this.ratingRepository.findAll();
        }

        return this.ratingRepository.findByAllBookId(bookId);
    }

    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepository.create(rating);
    }
}
