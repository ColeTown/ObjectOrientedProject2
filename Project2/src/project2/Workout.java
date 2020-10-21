package project2;

public class Workout {
    
    private int[] repsPerExercise;      //each of these arrays will have 5 elements, one for each seperate exercise
    private int[] totalReps;                //Push Ups, Squats, Sit Ups, Lounges, Burpees
    private int[] totalSkippedReps;
    
    public Workout() {
        
    }
    
    public void calculateRound(Card[] x) {
        //implement logic to set repsPerExercise
        updateTotals();
    }
    
    private void updateTotals() {
        //totalReps += repsPerExercise
        //totalSkippedReps += skipped
    }
    
    public int[] getCurrentReps() {
        return this.repsPerExercise;
    }
    
    public int[] getTotalReps() {
        return this.totalReps;
    }
    
    public int[] getTotalSkips() {
        return this.totalSkippedReps;
    }
}
