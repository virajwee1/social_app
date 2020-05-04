package com.app.postapi.domain;

public enum Reaction {

    EMPTY_REACTION(""), LIKE_REACTION("Like"), LOVE_REACTION("Love"),
    HAHA_REACTION("Haha"), WOW_REACTION("Wow"), SAD_REACTION("Sad"), ANDGRY_REACTION("Angry");

    final String reaction;

    Reaction(String reaction) {
        this.reaction = reaction;
    }

    @Override
    public String toString() {
        return reaction;
    }
}
