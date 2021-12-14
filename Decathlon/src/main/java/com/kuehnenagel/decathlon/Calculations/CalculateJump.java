package com.kuehnenagel.decathlon.Calculations;

public class CalculateJump implements CalculateEvent{

    @Override
    public int calculate(double athleteScores, Event event) {
            Double result = event.getA() * Math.pow(athleteScores*100- event.getB(), event.getC());
            return result.intValue();
        }

    }
