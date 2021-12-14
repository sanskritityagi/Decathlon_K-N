import com.kuehnenagel.decathlon.Model.AthleteScores;

import java.time.LocalTime;

public class LoadData {

    private LoadData(){}

    public static AthleteScores Player1() {
        return new AthleteScores.Athlete("Test1")
                .MTS_100(13.43)
                .long_jump(4.35)
                .shot_put(8.64)
                .high_jump(1.50)
                .MTS_400(66.06)
                .hurdles_100(19.05)
                .discus_throw(24.89)
                .pole_vault(2.20)
                .javelin_throw(33.48)
                .MTS_1500(LocalTime.of(0, 6, 51).toSecondOfDay()).create();
    }

    public static AthleteScores Player2() {
        return new AthleteScores.Athlete("Test2")
                .MTS_100(12.61)
                .long_jump(5.00)
                .shot_put(9.22)
                .high_jump(1.50)
                .MTS_400(60.39)
                .hurdles_100(16.43)
                .discus_throw(21.60)
                .pole_vault(2.60)
                .javelin_throw(35.81)
                .MTS_1500(LocalTime.of(0, 5, 25).toSecondOfDay()).create();
    }

    public static AthleteScores Player3() {
        return new AthleteScores.Athlete("Test3")
                .MTS_100(11.21)
                .long_jump(5.25)
                .shot_put(8.99)
                .high_jump(1.57)
                .MTS_400(59.39)
                .hurdles_100(17.43)
                .discus_throw(22.68)
                .pole_vault(2.67)
                .javelin_throw(34.99)
                .MTS_1500(LocalTime.of(0, 5, 57).toSecondOfDay()).create();
    }


}
