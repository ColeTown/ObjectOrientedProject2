package project2;

/*Class that creates a stack of cards, or a deck, based on user input. Adds the appropriate amount of cards you would typically see
in an uno deck, including wild and action cards. Also shuffles the deck, whether indivually or separate from the user as well as takes and adds
cards back to the deck based on the workout.*/

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

        //Creates the deck out of the following preset, running multiple times based on "numberOfDecks"
        for (int i = 0; i < numberOfDecks; i++) { 
            
            //adds two of each number 1-9 of each color and only 1 zero of each color
            for (int j = 1; j < 20; j++) { 
                Cards.add(new Card(0, j % 10, 0));
                Cards.add(new Card(1, j % 10, 0));
                Cards.add(new Card(2, j % 10, 0));
                Cards.add(new Card(3, j % 10, 0));
            }
            
            if (includeActionCards) {
                //will add two of each action card to the deck
                for (int x = 0; x < 6; x++) {
                    Cards.add(new Card(0, -1, 1 + x / 2));
                    Cards.add(new Card(1, -1, 1 + x / 2));
                    Cards.add(new Card(2, -1, 1 + x / 2));
                    Cards.add(new Card(3, -1, 1 + x / 2));
                }
            }
            
            //adds 4 of each type of wild card
            for (int y = 0; y < 4; y++) {
                Cards.add(new Card(-1, -1, 4));
                Cards.add(new Card(-1, -1, 5));
            }
        }

        //This is the logic used to shuffle the deck individually/together
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

    //takes n cards from the deck and returns them as an array
    public Card[] takeCard(int n) {
        if (Cards.size() < n) {
            n = Cards.size();
        }
        Card[] temp = new Card[n];
        for (int i = 0; i < n; i++) {
            temp[i] = Cards.remove(0);
        }
        return temp;
    }//end takeCard

    //places a card back into the deck at the end
    public void returnCard(Card x) {
        Cards.add(x);
    }//end returnCard
}
