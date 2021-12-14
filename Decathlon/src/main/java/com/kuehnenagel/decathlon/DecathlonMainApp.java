package com.kuehnenagel.decathlon;

import com.kuehnenagel.decathlon.Exception.InvalidParamException;
import com.kuehnenagel.decathlon.Model.Athlete;
import com.kuehnenagel.decathlon.Model.AthleteScores;
import com.kuehnenagel.decathlon.Services.GenerateXMLOutput;
import com.kuehnenagel.decathlon.Services.ParseCSVInput;
import com.kuehnenagel.decathlon.Services.ReadFile;
import com.kuehnenagel.decathlon.Services.ShareRank;
import java.util.List;

public class DecathlonMainApp {

    private final ParseCSVInput fileParser;
    private final ShareRank rankService;
    private final GenerateXMLOutput generateFile;

    private DecathlonMainApp() {
        fileParser = new ParseCSVInput(new ReadFile());
        rankService = new ShareRank();
        generateFile = new GenerateXMLOutput();
    }

    public static void main(String[] args) {
        DecathlonMainApp app = new DecathlonMainApp();
        app.start(app.getInputFilePath(args));
    }

    private void start(String filePath) {
        List<AthleteScores> athletes = fileParser.parseFile(filePath);
        List<Athlete> results = rankService.calculate(athletes);
        generateFile.generateOutputFile(results);
    }

    private String getInputFilePath(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        throw new InvalidParamException("Input file path required! Please provide input path");
    }

}

