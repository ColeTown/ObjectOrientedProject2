package project2;

public class Hand {
    
    private Card[] CurrentHand = new Card[7];
    
    public Hand() {
        
    }
    
    public void SortCards() {
        //sort the array CurrentHand by given criteria
    }
    
    public void setHand(Card[] newHand) {
        this.CurrentHand = newHand;
    }
    
    public Card[] getHand() {
        return this.CurrentHand;
    }
    
}
