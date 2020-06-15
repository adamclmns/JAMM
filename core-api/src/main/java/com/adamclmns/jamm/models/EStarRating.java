package com.adamclmns.jamm.models;

public enum EStarRating {
    NULL(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5);

    private int rating = 0;

    EStarRating(int i) {
        this.rating = i;
    }
}
