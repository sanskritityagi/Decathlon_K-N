package com.kuehnenagel.decathlon.Services;

import com.kuehnenagel.decathlon.Model.Athlete;
import com.kuehnenagel.decathlon.Model.AthleteScores;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShareRank {

    private Map<Integer, Integer> mapScore;

    public List<Athlete> calculate(List<AthleteScores> athleteScores) {
        mapScore = new HashMap<>();
        athleteScores.sort(Comparator.comparing(AthleteScores::getEvent).reversed());
        return athleteScores.stream().map(this::mapResult).collect(Collectors.toList());
    }

    private Athlete mapResult(AthleteScores athleteScores) {

        int decathlon = athleteScores.getEvent();

        if (! mapScore.containsKey(decathlon)) {
            mapScore.put(decathlon, mapScore.size() + 1);
        }

        return new Athlete(athleteScores.getName(), decathlon, mapScore.get(decathlon));
    }

}
