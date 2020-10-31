package project2;

public class Hand {
    
    private final int sizeOfHand = 7;
    private Card[] CurrentHand = new Card[sizeOfHand];
    
    public Hand() {
        
    }
    
    private void SortCards() {
        int indexOfSmallest;
        Card temp;
        for(int i = 0; i < sizeOfHand; i++) {
            indexOfSmallest = i;
         for(int j = i+1; j < sizeOfHand; j++) {   
          if(CurrentHand[indexOfSmallest].compareTo(CurrentHand[j]) == 1)   {
              indexOfSmallest = j;
          }
         }
         temp = CurrentHand[i];
         CurrentHand[i] = CurrentHand[indexOfSmallest];
         CurrentHand[indexOfSmallest] = temp;
        }
    }
    
    public void setHand(Card[] newHand) {
        this.CurrentHand = newHand;
        SortCards();
    }
    
    public Card[] getHand() {
        return this.CurrentHand;
    }
    
    public int getHandSize() {
        return this.sizeOfHand;
    }
    
}
