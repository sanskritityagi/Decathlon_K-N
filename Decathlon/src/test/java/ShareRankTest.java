import com.kuehnenagel.decathlon.Model.Athlete;
import com.kuehnenagel.decathlon.Model.AthleteScores;
import com.kuehnenagel.decathlon.Services.ShareRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShareRankTest {

    @Test
    public void rankWithTwoPlace() {

        List<AthleteScores> athleteScores = Arrays.asList(
                LoadData.Player1(),
                LoadData.Player2(),
                LoadData.Player3(),
                LoadData.Player3());

        ShareRank service = new ShareRank();

        List<Athlete> athletes = service.calculate(athleteScores);

        assertEquals(4, athletes.size());
        assertEquals(1, athletes.get(0).getRank());
        assertEquals(1, athletes.get(1).getRank());
        assertEquals(4374, athletes.get(0).getScore());
        //assertEquals(4374, athletes.get(1).getScore());
    }

}

