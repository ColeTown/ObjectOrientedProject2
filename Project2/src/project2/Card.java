package project2;

public class Card {
    
    private int Color; // 0 = Blue, 1 = Yellow, 2 = Red, 3 = Green, -1 = Wild cards
    private int Number; //-1 for action cards and wild cards
    private int cardType; // 0 = Default, 1 = Skip, 2 = Draw Two, 3 = Reverse, 4 = Wild, 5 = Wild Draw 4
    
    public Card(int color, int number, int cardType) {
        this.Color = color;
        this.Number = number;
        this.cardType = cardType;
    }
    
    @Override
    public String toString() {
        return "[" + Color + ", " + Number + ", " + cardType + "]";
    }
}
