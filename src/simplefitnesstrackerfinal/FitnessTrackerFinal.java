package simplefitnesstrackerfinal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FitnessTrackerFinal {

    private String activity;
    private int minutes = 0;
    private static double heartrate;
    private int caloriesburnt = 0;
    private static double oldheartrate = 80;
    private static int totalcaloriesburnt = 0;
    private float heartrateincrease = 0;
    final private double heartrateincreasepermin;
    final private int caloriesburntpermin;

    public FitnessTrackerFinal() {
        this.activity = "";
        this.caloriesburntpermin = 0;
        this.heartrateincreasepermin = 0;

    }

    public FitnessTrackerFinal(String activity, double heartrateincreasepermin, int caloriesburntpermin) {

        this.activity = activity;
        this.caloriesburntpermin = caloriesburntpermin;
        this.heartrateincreasepermin = heartrateincreasepermin;

    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public static double getHeartrate() {
        return heartrate;
    }

    public static void setHeartrate(double aHeartrate) {
        heartrate = aHeartrate;
    }

    public int getCaloriesburnt() {
        return caloriesburnt;
    }

    public void setCaloriesburnt(int caloriesburnt) {
        this.caloriesburnt = caloriesburnt;
    }

    public static int getTotalcaloriesburnt() {
        return totalcaloriesburnt;
    }

    public static void setTotalcaloriesburnt(int aTotalcaloriesburnt) {
        totalcaloriesburnt = aTotalcaloriesburnt;
    }

    public float getHeartrateincrease() {
        return heartrateincrease;
    }

    public void setHeartrateincrease(float heartrateincrease) {
        this.heartrateincrease = heartrateincrease;
    }

    public double getHeartrateincreasepermin() {
        return heartrateincreasepermin;
    }

    public void totalcaloriesBurnt() {
        setTotalcaloriesburnt(getTotalcaloriesburnt() + (minutes * caloriesburntpermin));
    }

    public void newHeartRate() {

        setHeartrate((oldheartrate * minutes * getHeartrateincreasepermin()) + oldheartrate);
        BigDecimal bd = new BigDecimal(heartrate).setScale(3, RoundingMode.HALF_UP);
        heartrate = (double) bd.doubleValue();

    }

    public void caloriesBurntPerType() {

        setCaloriesburnt(getCaloriesburnt() + (minutes * caloriesburntpermin));

    }

    public void heartRateIncrease() {
        setHeartrateincrease((float) ((getHeartrate() - oldheartrate) + getHeartrateincrease()));

        oldheartrate = getHeartrate();
        BigDecimal bd = new BigDecimal(this.heartrateincrease).setScale(3, RoundingMode.HALF_UP);
        this.heartrateincrease = (float) bd.doubleValue();

    }

    public void setTime(int minutes) {

        if (minutes >= 0) {
            this.minutes = minutes;
            totalcaloriesBurnt();
            caloriesBurntPerType();
            newHeartRate();
            heartRateIncrease();

        }
    }
    static FitnessTrackerFinal temp = new FitnessTrackerFinal();

    public static FitnessTrackerFinal[] ArraySorting(FitnessTrackerFinal array[]) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1].getCaloriesburnt() > array[j].getCaloriesburnt()) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (array[j].getCaloriesburnt() == array[j + 1].getCaloriesburnt()) {
                    if (array[j].getHeartrateincrease() < array[j + 1].getHeartrateincrease()) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;

                    }

                }
            }

        }
        return array;
    }

}
