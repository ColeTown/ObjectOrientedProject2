package project2;

import java.util.*;

public class Deck {
    
    private ArrayList<Card> Cards;
    private boolean hasActionCards;
    
    public Deck() {
        this(1, true, true);
    }
    
    public Deck(int numberOfDecks, boolean shuffledTogether, boolean includeActionCards) {
        this.hasActionCards = includeActionCards;
    }
    
    public Card takeCard(int i) {
        return Cards.remove(i);
    }
    
    public void returnCard(Card x) {
        Cards.add(x);
    }
    
}
