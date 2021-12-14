package com.kuehnenagel.decathlon.Calculations;


public enum Event {


        MTS_100(new CalculateTrack(), 25.4347, 18.0, 1.81),
        LONG_JUMP(new CalculateJump(), 0.14354, 220.0, 1.4),
        SHOT_PUT(new CalculateField(), 51.39, 1.5, 1.05),
        HIGH_JUMP(new CalculateJump(), 0.8465, 75.0, 1.42),
        MTS_400(new CalculateTrack(), 1.53775, 82.0, 1.81),
        HURDLES_100M(new CalculateTrack(), 5.74352, 28.5, 1.92),
        DISCUS_THROW(new CalculateField(), 12.91, 4.0, 1.1),
        POLE_VAULT(new CalculateJump(), 0.2797, 100.0, 1.35),
        JAVELIN_THROW(new CalculateField(), 10.14, 7.0, 1.08),
        MTS_1500(new CalculateTrack(), 0.03768, 480.0, 1.85),
        ;

        Event(CalculateEvent calculateEvent, double A, double B, double C) {
            this.calculateEvent = calculateEvent;
            this.A = A;
            this.B = B;
            this.C = C;
        }
         private final CalculateEvent calculateEvent;
         private final double A;
         private final double B;
         private final double C;


        public double getA() {
            return A;
        }

        public double getB() {
            return B;
        }

        public double getC() {
            return C;
        }

        public int calculate(double athleteScores) {

            return calculateEvent.calculate(athleteScores, this);
        }

    }
