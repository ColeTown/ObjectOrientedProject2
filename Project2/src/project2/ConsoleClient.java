package project2;

import java.util.Scanner;


public class ConsoleClient {
    
    private static Deck deck;
    private static Hand hand;
    private static Workout workout = new Workout();
    private static int numberOfDecks;
    private static boolean shuffleTogether;
    private static boolean includeActionCards;
    private static int round;
    
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("How many decks do you want: ");
        numberOfDecks = s.nextInt();
        System.out.println("Enter \"1\" to shuffle decks together and \"0\" to shuffle them seperatly: ");
        shuffleTogether = s.nextInt() == 1;
        System.out.println("Enter \"1\" to include action cards and \"0\" to not: ");
        includeActionCards = s.nextInt() == 1;
        deck = new Deck(numberOfDecks, shuffleTogether, includeActionCards);
        hand = new Hand();
        
        while(!deck.Cards.isEmpty()) {
            //one round will take place in one iteration of this loop
        }
        
        //end of workout will happen here
        
    }
    
}
