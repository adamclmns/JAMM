package com.adamclmns.jamm.api.io;

/**
 * The enum E star rating.
 */
public enum EStarRating {
    /**
     * Null e star rating.
     */
    NULL(0),
    /**
     * One e star rating.
     */
    ONE(1),
    /**
     * Two e star rating.
     */
    TWO(2),
    /**
     * Three e star rating.
     */
    THREE(3),
    /**
     * Four e star rating.
     */
    FOUR(4),
    /**
     * Five e star rating.
     */
    FIVE(5);

    private int rating = 0;

    EStarRating(int i) {
        this.rating = i;
    }
}
