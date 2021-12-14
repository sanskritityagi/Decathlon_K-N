package com.kuehnenagel.decathlon.Model;

public class Athlete {

    private final String name;
    private final int score;
    private final int rank;

    public Athlete(String name, int score, int rank) {
        this.name = name;
        this.score = score;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public int getRank() {
        return rank;
    }

}
