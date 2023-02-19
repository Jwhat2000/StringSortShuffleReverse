/*
Jeffrey Janvier
COP2805 - Homework #5.1
3/2/2022
This program prompts the user to enter a string that contains multiple words from a from
a graphical user interface and display them in a text area.
 */

package application;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LinkLists extends Application {
	@Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
		
		// Create a pane to hold the nodes in the method
		BorderPane pane = new BorderPane();
		
		// Create a pane to hold the nodes of the text field
		BorderPane paneForText = new BorderPane();
		paneForText.setPadding(new Insets(10, 10, 10, 10));
		paneForText.setLeft(new Label("Enter a string: ")); // Label to prompt user
		
		// Create text field to enter the string
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneForText.setCenter(tf);
		pane.setTop(paneForText);
		
		// Create text area to display the string
		TextArea tfArea = new TextArea();
		ScrollPane scrollPane = new ScrollPane(tfArea);
		pane.setCenter(scrollPane);
		
		// Process the event to display string in the text area
		tf.setOnAction(e -> tfArea.setText(textLinkList(tf)));
		tf.setOnMousePressed(e -> { if (tf.equals(tf))
								  tfArea.clear();
		});
		
		// Create pane to hold the buttons for the list
		HBox btsPane = new HBox(20);
        btsPane.setPadding(new Insets(5, 5, 5, 5));
        btsPane.setAlignment(Pos.CENTER);
        
        // Create buttons to sort, shuffle and reverse the list
        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        btsPane.getChildren().addAll(btSort, btShuffle, btReverse);
        pane.setBottom(btsPane); // Set buttons at the bottom of the pane
        
        // Process the event to display the sorted string in the text area
        btSort.setOnAction(e -> tfArea.setText(textSort(tfArea)));
        
        // Process the event to display the shuffled string in the text area
        btShuffle.setOnAction(e -> tfArea.setText(textShuffle(tfArea)));
        
        // Process the event to display the reversed string in the text area
        btReverse.setOnAction(e -> tfArea.setText(textReverse(tfArea)));
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Homework 5_1");
        primaryStage.setScene(scene);
        primaryStage.show();
	

	}

	public static void main(String[] args) {
		launch(args);

	}
	
	/* Method that calculate and display the string */
	public String textLinkList (TextField txt) {
		String textInput = txt.getText().toLowerCase();
		String[] txtArray = textInput.split("[\\s]");
		LinkedList<String> linkedText = new LinkedList<>(Arrays.asList(txtArray));
		  
		Set<String> linkedSet = new LinkedHashSet<>();
		linkedSet.addAll(linkedText);

		linkedText.clear();

		linkedText.addAll(linkedSet);
		  
		String strText = "";
		for (String string: linkedText)
			strText = strText + string + " ";
		return strText;
	}
	
	/* Method that sorts the string */
	public String textSort (TextArea txt) {
		 String textInput = txt.getText();
		 String[] txtArray = textInput.split("[\\s]");
		 LinkedList<String> linkedText = new LinkedList<>(Arrays.asList(txtArray));
		  
		 Collections.sort(linkedText);
		 String strText = "";
		 for (String string: linkedText)
			strText = strText + string + " ";
		 return strText;
	}
	
	/* Method that shuffles the string */
	public String textShuffle (TextArea txt) {
		String textInput = txt.getText();
		String[] txtArray = textInput.split("[\\s]");
		LinkedList<String> linkedText = new LinkedList<>(Arrays.asList(txtArray));
		  
		Collections.shuffle(linkedText);
		String strText = "";
		for (String string: linkedText)
			strText = strText + string + " ";
		return strText;
	}
	
	/* Method that reverses the string */
	public String textReverse (TextArea txt) {
		String textInput = txt.getText();
		String[] txtArray = textInput.split("[\\s]");
		LinkedList<String> linkedText = new LinkedList<>(Arrays.asList(txtArray));
		  
		Collections.reverse(linkedText);
		String strText = "";
		for (String string: linkedText)
			strText = strText + string + " ";
			return strText;
	}

}
