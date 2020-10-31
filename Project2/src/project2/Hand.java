package project2;

public class Hand {
    
    private int normalHandSize = 7;
    private Card[] CurrentHand;
    
    public Hand() {
    }
    
    private void SortCards() {
        int indexOfSmallest;
        Card temp;
        for(int i = 0; i < CurrentHand.length; i++) {
            indexOfSmallest = i;
         for(int j = i+1; j < CurrentHand.length; j++) {   

          if(CurrentHand[indexOfSmallest].compareTo(CurrentHand[j]) == 1)   {
              indexOfSmallest = j;
          }
         }
         temp = CurrentHand[i];
         CurrentHand[i] = CurrentHand[indexOfSmallest];
         CurrentHand[indexOfSmallest] = temp;
        }
    }
    
    public boolean setHand(Card[] newHand) {
        this.CurrentHand = newHand;
        SortCards();
        return newHand.length != 0;
    }
    
    public Card[] getHand() {
        return this.CurrentHand;
    }
    
    public int getCurrentHandSize() {
        return this.CurrentHand.length;
    }
    
    public int getNormalHandSize() {
        return this.normalHandSize;
    }
    
}
