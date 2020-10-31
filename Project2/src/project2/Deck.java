package project2;

import java.util.*;

public class Deck {
    
    public ArrayList<Card> Cards;
    private boolean hasActionCards;
    
    public Deck() {
        this(1, true, true);
        this.Cards = new ArrayList();
    }
    
    public Deck(int numberOfDecks, boolean shuffledTogether, boolean includeActionCards) {
        this.Cards = new ArrayList();
        this.hasActionCards = includeActionCards;

        for (int i = 0; i < numberOfDecks; i++) { //Creates the Deck
            for (int j = 1; j < 20; j++) { //adds two of each number 1-9 of each color and only 1 zero of each color
                Cards.add(new Card(0, j % 10, 0));
                Cards.add(new Card(1, j % 10, 0));
                Cards.add(new Card(2, j % 10, 0));
                Cards.add(new Card(3, j % 10, 0));
            }
            if (includeActionCards) {
                for (int x = 0; x < 6; x++) { //will add two of each action card to the deck
                    Cards.add(new Card(0, -1, 1 + x / 2));
                    Cards.add(new Card(1, -1, 1 + x / 2));
                    Cards.add(new Card(2, -1, 1 + x / 2));
                    Cards.add(new Card(3, -1, 1 + x / 2));
                }
            }
            for (int y = 0; y < 4; y++) {
                Cards.add(new Card(-1, -1, 4));
                Cards.add(new Card(-1, -1, 5));
            }
        }

        //This is the logic used to shuffle the deck individually and together
        if (shuffledTogether) {
            Collections.shuffle(Cards);
        } else {
            int singleDeckSize;
            if (includeActionCards) {
                singleDeckSize = 108;
            } else {
                singleDeckSize = 84;
            }
            Collections.shuffle(Cards.subList(0, singleDeckSize));
            if (numberOfDecks > 1) {
                Collections.shuffle(Cards.subList(singleDeckSize, singleDeckSize * 2));
                if (numberOfDecks > 2) {
                    Collections.shuffle(Cards.subList(singleDeckSize * 2, singleDeckSize * 3));
                }
            }
            
        }

    }
    
    public Card[] takeCard(int n) {
        if(Cards.size() < n) {
            n = Cards.size();
        }
        Card[] temp = new Card[n];
        for(int i = 0; i < n; i++) {
         temp[i] = Cards.remove(0);
        }
        return temp;
    }
    
    public void returnCard(Card x) {
        Cards.add(x);
    }
    
}
