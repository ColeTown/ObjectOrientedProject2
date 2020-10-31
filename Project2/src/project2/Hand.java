package project2;

public class Hand {

    private int normalHandSize = 7; //this is an option where we can change how many cards are in each hand
    private Card[] CurrentHand;

    public Hand() {
    }

    //uses Card.compareTo to sort the cards in the hand
    private void SortCards() {
        int indexOfSmallest;
        Card temp;
        for (int i = 0; i < CurrentHand.length; i++) {
            indexOfSmallest = i;
            for (int j = i + 1; j < CurrentHand.length; j++) {
                if (CurrentHand[indexOfSmallest].compareTo(CurrentHand[j]) == 1) {
                    indexOfSmallest = j;
                }
            }
            temp = CurrentHand[i];
            CurrentHand[i] = CurrentHand[indexOfSmallest];
            CurrentHand[indexOfSmallest] = temp;
        }
    }//end SortCards

    //sets the new hand and returns false if the new hand size is 0 -- false value is used to exit the new-round loop
    public boolean setHand(Card[] newHand) {
        this.CurrentHand = newHand;
        SortCards();
        return newHand.length != 0;
    }//end setHand

    public Card[] getHand() {
        return this.CurrentHand;
    }//end getHand

    //since the number of cards left might not be enough to fill a hand, we sometimes need to know how large the current hand is
    public int getCurrentHandSize() {
        return this.CurrentHand.length;
    }//end getCurrentHandSize

    public int getNormalHandSize() {
        return this.normalHandSize;
    }//end getNormalHandSize

}
