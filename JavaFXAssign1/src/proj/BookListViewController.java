package proj;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
/**
 * Controls the Book list
 * @author Max Crookshanks
 *
 */
public class BookListViewController implements Initializable {
	
	private BorderPane rootNode;
	
	@FXML private ListView<String> bookList;

	public BookListViewController() {
	}
	@FXML void goToBook(MouseEvent event) {
		if(event.getClickCount() == 2) {
			ViewSwitcher.getInstance().switchView(2,bookList.getSelectionModel().getSelectedItem());
		}
    }
	
	public void setRootNode(BorderPane rootNode) {
		this.rootNode = rootNode;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.bookList.getItems().add(bookList.getItems().size(),"Clifford");
		this.bookList.getItems().add(bookList.getItems().size(),"The Communist Manifesto");
		this.bookList.getItems().add(bookList.getItems().size(),"How to Git Good at Coding");
	}

}
