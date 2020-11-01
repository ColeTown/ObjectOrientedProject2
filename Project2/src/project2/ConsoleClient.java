package project2;

/* Class that allow the user to go through the exercises, and allowing the user to pick how many decks they want as well as if
they want to sort the decks individually or separate. Also allows the user to pick if they want action and wild cards in the workout.
Displays the data to the console for the user to read and creates an html file after each round to see data for the round.*/

import java.util.Scanner;


public class ConsoleClient {
    
    private static Deck deck;
    private static Hand hand;
    private static Workout workout = new Workout();
    private static int numberOfDecks;
    private static boolean shuffleTogether;
    private static boolean includeActionCards;
    private static int round = 1;

    
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
            System.out.println("Round " + round++);
            hand.setHand(deck.takeCard(hand.getNormalHandSize()));
            //one round takes place in one iteration of this loop
            String tempString = "Cards: ";
            Card[] tempHand = hand.getHand();
            for (int i = 0; i < hand.getCurrentHandSize(); i++) {
                Card tempCard = tempHand[i];
                switch (tempCard.getColor()) {
                    case -1: tempString += "Wild "; break;
                    case 0: tempString += "Blue "; break;
                    case 1: tempString += "Yellow "; break;
                    case 2: tempString += "Red "; break;
                    case 3: tempString += "Green "; break;
                }
                if (tempCard.getNumber() != -1) {
                    tempString += tempCard.getNumber();
                }
                switch (tempCard.getCardType()) {
                    case 1: tempString += "Skip"; break;
                    case 2: tempString += "Draw Two"; break;
                    case 3: tempString += "Reverse"; break;
                    case 4: tempString += "Card"; break;
                    case 5: tempString += "Draw Four"; break;
                }
                if (i != hand.getCurrentHandSize() - 1) {
                    tempString += ", ";
                }
            }
            System.out.println(tempString);
            workout.calculateRound(hand.getHand(), hand.getCurrentHandSize());

            int pushups = workout.getCurrentPushReps();
            int squats = workout.getCurrentSquatReps();
            int situps = workout.getCurrentSitReps();
            int lunges = workout.getCurrentLungeReps();
            int burpees = workout.getCurrentBurpReps();
            
            System.out.println();
            System.out.println("Exercises: \n    " + pushups + " Push Ups\n    " + squats + " Squats\n    " + situps + " Situps\n    " + lunges + " Lunges\n    " + burpees + " Burpees");
            System.out.println();
            System.out.println(tempString = "Statistics: \n    ");
            System.out.println();
            System.out.println(tempString += "Cards Left: " + deck.Cards.size());
            System.out.println();
        
        System.out.println();
        System.out.println("Workout Over");
        System.out.println();
        System.out.println("Statistics: \n   ");
        System.out.println();
        System.out.println("Total Skiped Reps: " + workout.getTotalSkips() + "\n\n   ");
        System.out.println("Total Push Ups: " + workout.getTotalPushReps() + "\n   ");
        System.out.println("Total Squats: " + workout.getTotalSquatReps() + "\n   ");
        System.out.println("Total Situps: " + workout.getTotalSitReps() + "\n   ");
        System.out.println("Total Lunges: " + workout.getTotalLungeReps() + "\n   ");
        System.out.println("Total Burpees: " + workout.getTotalBurpReps() + "\n   ");
        
        }//end main

    }//end ConsoleClient
}

