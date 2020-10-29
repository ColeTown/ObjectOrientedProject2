package project2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project2 extends Application {

    private static Deck deck;
    private static Hand hand;
    private static int numberOfDecks;
    private static boolean shuffleTogether;
    private static boolean includeActionCards;
    
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
 });
        
        remove.setText("Remove");
        remove.setOnAction((ActionEvent event) -> {
            deck = new Deck(numberOfDecks, shuffleTogether, false);
            System.out.println("Not Included Chosen");
 });
        

        GridPane root = new GridPane();
        root.add(include, 1, 1);
        root.add(remove, 1, 2);
        return root;
}

//public static GridPane roundScene(Stage primaryStage) {
// primaryStage.setTitle("Round " + round); //round can be kept up with on a global variable
//
// 
//        Pane root = new Pane();
//        return root;
//
//}

}
