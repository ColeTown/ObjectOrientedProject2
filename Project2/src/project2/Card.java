package project2;

public class Card {
    
    private final int Color; // 0 = Blue, 1 = Yellow, 2 = Red, 3 = Green
    private final int Number;
    private final int cardType;
    
    public Card(String color, int number, int cardType) {
        this.Color = color;
        this.Number = number;
        this.cardType = cardType;
    }
    
}
