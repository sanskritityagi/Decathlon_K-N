package com.kuehnenagel.decathlon.Services;

import com.kuehnenagel.decathlon.Exception.ReadFileException;
import com.kuehnenagel.decathlon.Model.AthleteScores;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import static com.kuehnenagel.decathlon.Utils.Utility.*;


public class ParseCSVInput implements ParsInput {

    private final ReadFile readFile;

    public ParseCSVInput(ReadFile readFile) {
        this.readFile = readFile;
    }

    @Override
    public List<AthleteScores> parseFile(String filePath) {
        List<String> lines = readFile.read(filePath);
        return lines.stream().map(this::map).collect(Collectors.toList());
    }

    private AthleteScores map(String line) {

        String[] values = line.split(";");

        return new AthleteScores.Athlete(values[INDEX_NAME])
                .MTS_100(Double.valueOf(values[INDEX_100_M]))
                .long_jump(Double.valueOf(values[INDEX_LONG_JUMP]))
                .shot_put(Double.valueOf(values[INDEX_SHOT_PUT]))
                .high_jump(Double.valueOf(values[INDEX_HIGH_JUMP]))
                .MTS_400(Double.valueOf(values[INDEX_400_M]))
                .hurdles_100(Double.valueOf(values[INDEX_100_M_HURDLES]))
                .discus_throw(Double.valueOf(values[INDEX_DISCUS_THROW]))
                .pole_vault(Double.valueOf(values[INDEX_POLE_VAULT]))
                .javelin_throw(Double.valueOf(values[INDEX_JAVELIN_THROW]))
                .MTS_1500(ConvertToSeconds(values[INDEX_1500_M]))
                .create();
    }

    public static Integer ConvertToSeconds(String value) {
        try {
            String[] split = value.trim().split("\\.");
            LocalTime test = LocalTime.of(0, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            return test.toSecondOfDay();
        } catch (Exception e) {
            throw new ReadFileException(String.format("Error on convert %s to seconds. Error: %s", value, e.getMessage()));
        }
    }
}
