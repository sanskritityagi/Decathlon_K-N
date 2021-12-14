package com.kuehnenagel.decathlon.Calculations;

public class CalculateTrack implements CalculateEvent {

    @Override
    public int calculate(double athleteScores, Event event) {
        Double result = event.getA() * Math.pow(event.getB() - athleteScores, event.getC());
        return result.intValue();
}
}
