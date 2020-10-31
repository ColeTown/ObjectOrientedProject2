package project2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Project2 extends Application {

    private static Deck deck;
    private static Hand hand;
    private static int numberOfDecks;
    private static boolean shuffleTogether;
    private static boolean includeActionCards;
    private static int round;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane root = firstScene(primaryStage);
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

    public static GridPane firstScene(Stage primaryStage) {
        primaryStage.setTitle("Choose how many decks to have.");
        Button oneDeck = new Button();
        Button twoDecks = new Button();
        Button threeDecks = new Button();
        oneDeck.setText("1 Deck");
        oneDeck.setOnAction((ActionEvent event) -> {
            System.out.println("One Deck Chosen");
            numberOfDecks = 1;
            primaryStage.getScene().setRoot(secondScene(primaryStage)); //Changes the scene to the next set of buttons
        });

        twoDecks.setText("2 Decks");
        twoDecks.setOnAction((ActionEvent event) -> {
            System.out.println("Two Decks Chosen");
            numberOfDecks = 2;
            primaryStage.getScene().setRoot(secondScene(primaryStage));
        });

        threeDecks.setText("3 Decks");
        threeDecks.setOnAction((ActionEvent event) -> {
            System.out.println("Three Decks Chosen");
            numberOfDecks = 3;
            primaryStage.getScene().setRoot(secondScene(primaryStage));
        });

        GridPane root = new GridPane();
        root.add(oneDeck, 1, 1);
        root.add(twoDecks, 1, 2);
        root.add(threeDecks, 1, 3);
        return root;
    }

    public static GridPane secondScene(Stage primaryStage) {
        primaryStage.setTitle("Shuffle Decks Individually or Together");
        Button individual = new Button();
        Button together = new Button();
        individual.setText("Individually");
        individual.setOnAction((ActionEvent event) -> {
            System.out.println("Individually Chosen");
            shuffleTogether = false;
            primaryStage.getScene().setRoot(thirdScene(primaryStage));
        });

        together.setText("Together");
        together.setOnAction((ActionEvent event) -> {
            System.out.println("Together Chosen");
            shuffleTogether = true;
            primaryStage.getScene().setRoot(thirdScene(primaryStage));
        });

        GridPane root = new GridPane();
        root.add(individual, 1, 1);
        root.add(together, 1, 2);
        return root;
    }

    public static GridPane thirdScene(Stage primaryStage) {
        primaryStage.setTitle("Include or remove action cards.");
        Button include = new Button();
        Button remove = new Button();
        include.setText("Include");
        include.setOnAction((ActionEvent event) -> {
            deck = new Deck(numberOfDecks, shuffleTogether, true);
            System.out.println("Included Chosen");
            hand = new Hand();
            round = 1;
            primaryStage.getScene().setRoot(roundScene(primaryStage));
        });

        remove.setText("Remove");
        remove.setOnAction((ActionEvent event) -> {
            deck = new Deck(numberOfDecks, shuffleTogether, false);
            System.out.println("Not Included Chosen");
            hand = new Hand();
            round = 1;
            primaryStage.getScene().setRoot(roundScene(primaryStage));
        });

        GridPane root = new GridPane();
        root.add(include, 1, 1);
        root.add(remove, 1, 2);
        return root;
    }

    public static GridPane roundScene(Stage primaryStage) {
        if(hand.setHand(deck.takeCard(hand.getNormalHandSize()))) {
        primaryStage.setTitle("Round " + round++);
        
        Button nextRound = new Button();
        nextRound.setText("Next Round");
        nextRound.setOnAction((ActionEvent event) -> {
            
            primaryStage.getScene().setRoot(roundScene(primaryStage));
        });
        
            String tempString = "Cards: ";
            Card[] tempHand = hand.getHand();
            for (int i = 0; i < hand.getCurrentHandSize(); i++) {
                Card tempCard = tempHand[i];
                System.out.println(tempCard);
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
            Text cards = new Text(tempString);

            int x = 0; //these will come from the workout class data
            int y = 0;
            int z = 0;
            int a = 0;
            int b = 0;

        Text exercises = new Text("Exercises: " + x + " Push Ups, " + y + " Squats, " + z + " Situps, " + a + " Lounges, " + b + " Burpees");
        
        GridPane root = new GridPane();
        root.add(nextRound, 1, 1);
        root.add(cards, 1, 2);
        root.add(exercises, 1, 3);
        return root;
        } else {
            return finalScene(primaryStage);
        }
    }
    
    public static GridPane finalScene(Stage primaryStage) {
        primaryStage.setTitle("Workout Over");
        
        GridPane root = new GridPane();
        return root;
    }

}
