package org.rado.ratingapi.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Rating {

    private Long id;
    private Long bookId;
    private Integer stars;
}
