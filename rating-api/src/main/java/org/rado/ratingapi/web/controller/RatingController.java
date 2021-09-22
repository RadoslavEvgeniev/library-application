package org.rado.ratingapi.web.controller;

import org.rado.ratingapi.db.entity.Rating;
import org.rado.ratingapi.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("")
    public ResponseEntity<List<Rating>> findAllByBookId(@RequestParam(required = false, defaultValue = "0") Long bookId) {
        return new ResponseEntity<>(this.ratingService.findAllRatingsByBookId(bookId), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(this.ratingService.createRating(rating), HttpStatus.CREATED);
    }
}
