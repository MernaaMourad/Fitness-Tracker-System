package simplefitnesstrackerfinal;

public class SimpleFitnessTrackerFinal {

    public static void main(String[] args) {
        FitnessTrackerFinal swimming = new FitnessTrackerFinal("Swimming", 0.002, 4);
        FitnessTrackerFinal running = new FitnessTrackerFinal("Running", 0.003, 5);
        FitnessTrackerFinal kick_boxing = new FitnessTrackerFinal("Kick_boxing", 0.005, 3);
        FitnessTrackerFinal strength_training = new FitnessTrackerFinal("Strength_training", 0.006, 5);
        FitnessTrackerFinal arrayactivity[] = {swimming, running, kick_boxing, strength_training};
        MainJFrame obj = new MainJFrame(arrayactivity);
        obj.setVisible(true);

    }
}
