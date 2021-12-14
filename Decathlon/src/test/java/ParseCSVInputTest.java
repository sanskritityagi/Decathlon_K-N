import com.kuehnenagel.decathlon.Model.AthleteScores;
import com.kuehnenagel.decathlon.Services.ParsInput;
import com.kuehnenagel.decathlon.Services.ParseCSVInput;
import com.kuehnenagel.decathlon.Services.ReadFile;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParseCSVInputTest {

    @Test
    public void parseCsv() {

        ParsInput fileParser = new ParseCSVInput(new ReadFile());

        List<AthleteScores> athletePerformances = fileParser.parseFile(null);

        assertEquals(4, athletePerformances.size());
        assertEquals("John Smith", athletePerformances.get(0).getName());
        assertEquals("Foo Bar", athletePerformances.get(3).getName());

    }


}
