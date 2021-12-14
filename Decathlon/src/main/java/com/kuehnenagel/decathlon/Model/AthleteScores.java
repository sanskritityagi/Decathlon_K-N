package com.kuehnenagel.decathlon.Model;

import com.kuehnenagel.decathlon.Calculations.Event;

import java.util.Optional;

public class AthleteScores {

        private int event = -1;

        private final String name;
        private final Double MTS_100;
        private final Double long_jump;
        private final Double shot_put;
        private final Double high_jump;
        private final Double MTS_400;
        private final Double hurdles_100;
        private final Double discus_throw;
        private final Double pole_vault;
        private final Double javelin_throw;
        private final Integer MTS_1500;

        public int getEvent() {
            if (event == -1) {
                event = calculateDecathlon();
            }
            return event;
        }

        private int calculateDecathlon() {
            return calculate100m() +
                    calculateLongJump() +
                    calculateShotPut() +
                    calculateHighJump() +
                    calculate400m() +
                    calculate110mHurdles() +
                    calculateDiscusThrow() +
                    calculatePoleVault() +
                    calculateJavelinThrow() +
                    calculate1500m();
        }

        public String getName() {
            return name;
        }

        public int calculate100m() {
            return Optional.ofNullable(MTS_100).map(Event.MTS_100::calculate).orElse(0);
        }

        public int calculateLongJump() {
            return Optional.ofNullable(long_jump).map(Event.LONG_JUMP::calculate).orElse(0);
        }

        public int calculateShotPut() {
            return Optional.ofNullable(shot_put).map(Event.SHOT_PUT::calculate).orElse(0);
        }

        public int calculateHighJump() {
            return Optional.ofNullable(high_jump).map(Event.HIGH_JUMP::calculate).orElse(0);
        }

        public int calculate400m() {
            return Optional.ofNullable(MTS_400).map(Event.MTS_400::calculate).orElse(0);
        }

        public int calculate110mHurdles() {
            return Optional.ofNullable(hurdles_100).map(Event.HURDLES_100M::calculate).orElse(0);
        }

        public int calculateDiscusThrow() {
            return Optional.ofNullable(discus_throw).map(Event.DISCUS_THROW::calculate).orElse(0);
        }

        public int calculatePoleVault() {
            return Optional.ofNullable(pole_vault).map(Event.POLE_VAULT::calculate).orElse(0);
        }

        public int calculateJavelinThrow() {
            return Optional.ofNullable(javelin_throw).map(Event.JAVELIN_THROW::calculate).orElse(0);
        }

        public int calculate1500m() {
            return Optional.ofNullable(MTS_1500).map(Event.MTS_1500::calculate).orElse(0);
        }

        public static class Athlete {

            private final String name;

            private Double sprint100m = null;
            private Double longJump = null;
            private Double shotPut = null;
            private Double highJump = null;
            private Double sprint400m = null;
            private Double sprint110mHurdles = null;
            private Double discusThrow = null;
            private Double poleVault = null;
            private Double javelinThrow = null;
            private Integer sprint1500mInSeconds = null;

            public Athlete(String name) {
                this.name = name;
            }

            public Athlete MTS_100(Double sprint100m) {
                this.sprint100m = sprint100m;
                return this;
            }

            public Athlete long_jump(Double longJump) {
                this.longJump = longJump;
                return this;
            }

            public Athlete shot_put(Double shotPut) {
                this.shotPut = shotPut;
                return this;
            }

            public Athlete high_jump(Double highJump) {
                this.highJump = highJump;
                return this;
            }

            public Athlete MTS_400(Double sprint400m) {
                this.sprint400m = sprint400m;
                return this;
            }

            public Athlete hurdles_100(Double sprint110mHurdles) {
                this.sprint110mHurdles = sprint110mHurdles;
                return this;
            }

            public Athlete discus_throw(Double discusThrow) {
                this.discusThrow = discusThrow;
                return this;
            }

            public Athlete pole_vault(Double poleVault) {
                this.poleVault = poleVault;
                return this;
            }

            public Athlete javelin_throw(Double javelinThrow) {
                this.javelinThrow = javelinThrow;
                return this;
            }

            public Athlete MTS_1500(Integer sprint1500mInSeconds) {
                this.sprint1500mInSeconds = sprint1500mInSeconds;
                return this;
            }

            public AthleteScores create() {
                return new AthleteScores(this);
            }
        }

        private AthleteScores(Athlete athlete) {
            name = athlete.name;
            MTS_100 = athlete.sprint100m;
            long_jump = athlete.longJump;
            shot_put = athlete.shotPut;
            high_jump = athlete.highJump;
            MTS_400 = athlete.sprint400m;
            hurdles_100 = athlete.sprint110mHurdles;
            discus_throw = athlete.discusThrow;
            pole_vault = athlete.poleVault;
            javelin_throw = athlete.javelinThrow;
            MTS_1500 = athlete.sprint1500mInSeconds;
        }
    }

