import com.kuehnenagel.decathlon.Model.AthleteScores;
import org.junit.Test;

import java.time.LocalTime;
import static org.junit.Assert.assertEquals;

public class AthleteScoresTest {

    @Test
    public void calculateEvent() {
        AthleteScores athleteScores = LoadData.Player1();
        assertEquals(3099, athleteScores.getEvent());
    }
    @Test
    public void calculateWithoutValues() {
        AthleteScores noValues = new AthleteScores.Athlete("NoValues").create();
        assertEquals(0, noValues.getEvent());
    }

    @Test
    public void calculateSprint100m() {
        AthleteScores sprint100m = new AthleteScores.Athlete("Sprint100m").MTS_100(13.04).create();
        assertEquals(461, sprint100m.calculate100m());
    }

    @Test
    public void calculateLongJump() {
        AthleteScores longJump = new AthleteScores.Athlete("LongJump").long_jump(5.00).create();
        assertEquals(382, longJump.calculateLongJump());
    }

    @Test
    public void calculateShotPut() {
        AthleteScores shotPut = new AthleteScores.Athlete("ShotPut").shot_put(9.22).create();
        assertEquals(439, shotPut.calculateShotPut());
    }

    @Test
    public void calculateHighJump() {
        AthleteScores highJump = new AthleteScores.Athlete("HighJump").high_jump(1.50).create();
        assertEquals(389, highJump.calculateHighJump());
    }

    @Test
    public void calculate400m() {
        AthleteScores sprint400m = new AthleteScores.Athlete("Sprint400m").MTS_400(60.39).create();
        assertEquals(400, sprint400m.calculate400m());
    }

    @Test
    public void calculate110mHurdles() {
        AthleteScores sprint110mHurdles = new AthleteScores.Athlete("Sprint110mHurdles").hurdles_100(16.43).create();
        assertEquals(685, sprint110mHurdles.calculate110mHurdles());
    }

    @Test
    public void calculateDiscusThrow() {
        AthleteScores discusThrow = new AthleteScores.Athlete("DiscusThrow").discus_throw(21.60).create();
        assertEquals(302, discusThrow.calculateDiscusThrow());
    }

    @Test
    public void calculatePoleVault() {
        AthleteScores poleVault = new AthleteScores.Athlete("PoleVault").pole_vault(2.60).create();
        assertEquals(264, poleVault.calculatePoleVault());
    }

    @Test
    public void calculateJavelinThrow() {
        AthleteScores javelinThrow = new AthleteScores.Athlete("JavelinThrow").javelin_throw(35.81).create();
        assertEquals(382, javelinThrow.calculateJavelinThrow());
    }

    @Test
    public void calculateSprint1500m() {

        AthleteScores javelinThrow = new AthleteScores.Athlete("Sprint1500mts").MTS_1500(LocalTime.of(0, 5, 25).toSecondOfDay()).create();
        assertEquals(424, javelinThrow.calculate1500m());
    }


}
