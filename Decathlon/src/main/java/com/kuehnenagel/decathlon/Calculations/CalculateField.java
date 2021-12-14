package com.kuehnenagel.decathlon.Calculations;

public class CalculateField implements CalculateEvent {

    @Override
    public int calculate(double athleteScores, Event event) {
        Double result = event.getA() * Math.pow(athleteScores - event.getB(), event.getC());
        return result.intValue();
    }
}
