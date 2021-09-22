package org.rado.ratingapi.service;

import org.rado.ratingapi.db.entity.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> findAllRatingsByBookId(Long bookId);

    Rating createRating(Rating rating);
}
