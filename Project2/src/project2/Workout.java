package project2;

public class Workout extends Deck{
    
        private int currentPushReps;
        private int currentSquatReps;
        private int currentSitReps;
        private int currentLungeReps;
        private int currentBurpReps;
        
        private int totalPushReps;
        private int totalSquatReps;
        private int totalSitReps;
        private int totalLungeReps;
        private int totalBurpReps;
        private int totalSkipped;
    
    public Workout() {
        
    }
    
    public void calculateRound(Card[] x, int handSize) {
        
        currentPushReps = 0;
        currentSquatReps = 0;
        currentSitReps = 0;
        currentLungeReps = 0;
        currentBurpReps = 0;
        
        //logic to set reps for each exercise with defualt cards
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 0) {
                switch (x[i].getColor()) {
                    case 0 : currentPushReps += x[i].getNumber(); break;
                    case 1 : currentSquatReps += x[i].getNumber(); break;
                    case 2 : currentSitReps += x[i].getNumber(); break;
                    case 3 : currentLungeReps += x[i].getNumber(); break;
                }//end switch
            }
            else {
            }
        }
        //Loop through hand again to calculate skips after default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 1) {
                switch (x[i].getColor()) {
                    case 0 : totalSkipped += currentPushReps; currentPushReps = 0; break;
                    case 1 : totalSkipped += currentSquatReps; currentSquatReps = 0; break;
                    case 2 : totalSkipped += currentSitReps; currentSitReps = 0; break;
                    case 3 : totalSkipped += currentLungeReps; currentLungeReps = 0; break;
                }
            }
            else {
            }
        }
        //Loop through hand again to calculate draw 2 after skip and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 2) {
                switch (x[i].getColor()) {
                    case 0 : currentPushReps = currentPushReps * 2; break;
                    case 1 : currentSquatReps = currentSquatReps * 2; break;
                    case 2 : currentSitReps = currentSitReps * 2; break;
                    case 3 : currentLungeReps = currentLungeReps * 2; break;
                }
            }
            else {
            }
        }
        //Loop through hand again to calculate reverse after draw2, skip, and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 3) {
                for(int j = 0; j < handSize; j++ ) {
                    if(i != j) {
                    switch (x[i].getColor()) {
                         case 0 : super.returnCard(x[j]); currentPushReps = 0; break;
                         case 1 : super.returnCard(x[j]); currentSquatReps = 0; break;
                         case 2 : super.returnCard(x[j]); currentSitReps = 0; break;
                         case 3 : super.returnCard(x[j]); currentLungeReps = 0; break;
                    }
                    }
                }
            }
            else {
            }
        }
        //Loop through hand again to calculate wild after reverse, draw 2, skip and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 4) {
                currentBurpReps = currentBurpReps + 4;
            }
            else {
            }
        }
        //Loop through hand again to calculate wild 4 after wild, reverse, draw 2, skip and default cards have been counted
        for(int i = 0; i < handSize; i++ ) {
            if(x[i].getCardType() == 5) {
                currentBurpReps = currentBurpReps + 4;
                switch (x[i].getColor()) {
                    case 0 : currentPushReps = currentPushReps * 4; break;
                    case 1 : currentSquatReps = currentSquatReps * 4; break;
                    case 2 : currentSitReps = currentSitReps * 4; break;
                    case 3 : currentLungeReps = currentLungeReps * 4; break;
                }
            }
            else {
            }
        }
        
        //Updates total reps for each exercise
        totalPushReps += currentPushReps;
        totalSquatReps += currentSquatReps;
        totalSitReps += currentSitReps;
        totalLungeReps += currentLungeReps;
        totalBurpReps += currentBurpReps;
        
    }//end CalculateRound
    

    
    public int getCurrentPushReps() {
        return this.currentPushReps;
    }//end getCurrentPushReps
    
    public int getCurrentSquatReps() {
        return this.currentSquatReps;
    }//end getCurrentSquatReps
    
    public int getCurrentSitReps() {
        return this.currentSitReps;
    }//end getCurrentSitReps
    
    public int getCurrentLungeReps() {
        return this.currentLungeReps;
    }//end getCurrentLungeReps
    
    public int getCurrentBurpReps() {
        return this.currentBurpReps;
    }//end getCurrentBurpReps
    
    public int getTotalPushReps() {
        return this.totalPushReps;
    }//end getTotalPush Reps
    
    public int getTotalSquatReps() {
        return this.totalSquatReps;
    }//end getTotalSquatReps
    
    public int getTotalSitReps() {
        return this.totalSitReps;
    }//end getTotalSitReps
    
    public int getTotalLungeReps() {
        return this.totalLungeReps;
    }//end getTotalLungeReps
    
    public int getTotalBurpReps() {
        return this.totalBurpReps;
    }//end getTotalBurpReps
    
    public int getTotalSkips() {
        return this.totalSkipped;
    }//end getTotalSkips
    
}//end Workout
