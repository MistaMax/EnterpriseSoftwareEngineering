package proj;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
/**
 * Controls the detail view of a select Book
 * @author Max Crookshanks
 *
 */
public class BookDetailViewController implements Initializable {
	private BorderPane rootNode;
	
	private String title;
	
	private String summary;
	
	private int yearPublished;
	
	private String iSBN;
	
	private String dateAdded;
	//Initializes the variables, 
	//I know this should generally be stored in a model 
	//but since this assignment is just about view, I 
	//did not deem it necessary
	public BookDetailViewController(String title) {
		this.title = title;
		if(title.compareTo("Clifford") == 0){
			this.summary="Its about a big red dog....";
			this.yearPublished = 1990;
			this.iSBN = "978-3-16-148410-0";
			this.dateAdded = "06/15/18";
		}else if(title.compareTo("The Communist Manifesto")==0) {
			this.summary="Its about communism and stuff";
			this.yearPublished = 1940;
			this.iSBN = "978-3-16-148410-1";
			this.dateAdded = "09/20/2001";
		}else if(title.compareTo("How to Git Good at Coding")==0) {
			this.summary="Its about how to use git and stuff";
			this.yearPublished = 2010;
			this.iSBN = "978-3-16-148410-2";
			this.dateAdded = "10/5/17";
		}
	}
	
	@FXML private ListView<String> bookDetailList;

    @FXML private Button saveButton;
    //Runs if the save button is pressed
    @FXML void runSave(ActionEvent event) {
    	ViewSwitcher.getInstance().getLogger().info("Save Button Pressed");
    }

	public void setRootNode(BorderPane rootNode) {
		this.rootNode = rootNode;
	}
	//sets all the book details to the corresponding values
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.bookDetailList.getItems().add("Title: "+title);
		this.bookDetailList.getItems().add("Summary: "+summary);
		this.bookDetailList.getItems().add("Year Published: "+Integer.toString(yearPublished));
		this.bookDetailList.getItems().add("ISBN: "+iSBN);
		this.bookDetailList.getItems().add("Date Added: "+dateAdded);
	}

}