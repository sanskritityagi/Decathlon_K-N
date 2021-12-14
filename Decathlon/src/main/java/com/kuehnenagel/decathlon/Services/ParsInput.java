package com.kuehnenagel.decathlon.Services;
import com.kuehnenagel.decathlon.Model.AthleteScores;

import java.util.List;

public interface ParsInput {
        List<AthleteScores> parseFile(String filePath);

    }


