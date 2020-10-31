package project2;

public class Workout extends Deck{
    
        private int pushReps;
        private int squatReps;
        private int sitReps;
        private int lungeReps;
        private int burpReps;
        private int totalSkipped;
    
    public Workout() {
        
    }
    
    public void calculateRound(Card[] x, int handSize) {
        //logic to set reps for each exercise with defualt cards
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 0) {
                switch (x[i].getColor()) {
                    case 0 : pushReps += x[i].getNumber(); break;
                    case 1 : squatReps += x[i].getNumber(); break;
                    case 2 : sitReps += x[i].getNumber(); break;
                    case 3 : lungeReps += x[i].getNumber(); break;
                }//end switch
            }
            else {
            }
        }
        //Loop through hand again to calculate skips after default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 1) {
                switch (x[i].getColor()) {
                    case 0 : totalSkipped += pushReps; pushReps = 0; break;
                    case 1 : totalSkipped += squatReps; squatReps = 0; break;
                    case 2 : totalSkipped += sitReps; sitReps = 0; break;
                    case 3 : totalSkipped += lungeReps; lungeReps = 0; break;
                }
            }
            else {
            }
        }
        //Loop through hand again to calculate draw 2 after skip and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 2) {
                switch (x[i].getColor()) {
                    case 0 : pushReps = pushReps * 2; break;
                    case 1 : squatReps = squatReps * 2; break;
                    case 2 : sitReps = sitReps * 2; break;
                    case 3 : lungeReps = lungeReps * 2; break;
                }
            }
            else {
            }
        }
        //Loop through hand again to calculate reverse after draw2, skip, and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 3) {
                for(int j = 0; i < handSize; j++ ) {
                    switch (x[i].getColor()) {
                         case 0 : super.returnCard(x[j]); pushReps = 0; break;
                         case 1 : super.returnCard(x[j]); squatReps = 0; break;
                         case 2 : super.returnCard(x[j]); sitReps = 0; break;
                         case 3 : super.returnCard(x[j]); lungeReps = 0; break;
                    }
                }
            }
            else {
            }
        }
        //Loop through hand again to calculate wild after reverse, draw 2, skip and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 4) {
                burpReps = burpReps + 4;
            }
            else {
            }
        }
        //Loop through hand again to calculate wild 4 after wild, reverse, draw 2, skip and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 5) {
                burpReps = burpReps + 4;
                switch (x[i].getColor()) {
                    case 0 : pushReps = pushReps * 4; break;
                    case 1 : squatReps = squatReps * 4; break;
                    case 2 : sitReps = sitReps * 4; break;
                    case 3 : lungeReps = lungeReps * 4; break;
                }
            }
            else {
            }
        }
    }//end CalculateRound
    
    public int getTotalPushReps() {
        return this.pushReps;
    }//end getTotalPushReps
    
    public int getTotalSquatReps() {
        return this.squatReps;
    }//end getTotalSquatReps
    
    public int getTotalSitReps() {
        return this.sitReps;
    }//end getTotalSitReps
    
    public int getTotalLungeReps() {
        return this.lungeReps;
    }//end getTotalLungeReps
    
    public int getTotalBurpReps() {
        return this.burpReps;
    }//end getTotalBurpReps
    
    public int getTotalSkips() {
        return this.totalSkipped;
    }//end getTotalSkips
    
}//end Workout
