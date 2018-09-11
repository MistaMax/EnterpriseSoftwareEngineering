package proj;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * Assignment 1 by Max Crookshanks
 * @author Max Crookshanks
 *
 */
public class Launcher extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//loads in the Main view that contains the menu at the top of the application
		URL fxmlFile = this.getClass().getResource("MainView.fxml");
		FXMLLoader loader = new FXMLLoader(fxmlFile);
		MainViewController main = new MainViewController();
		loader.setController(main);
		BorderPane rootNode = loader.load();
		ViewSwitcher.getInstance().setRootNode(rootNode);
		main.setRootNode((BorderPane) rootNode);
		Scene scene = new Scene(rootNode, 600, 400);
		stage.setTitle("Book Checker");
		stage.setScene(scene);
		stage.show();		
		//Loads in the book list
		BookListViewController controller = new BookListViewController();
		controller.setRootNode((BorderPane) rootNode);

		fxmlFile = this.getClass().getResource("BookListView.fxml");
		loader = new FXMLLoader(fxmlFile);
	
		loader.setController(controller);
	
		Parent contentView = loader.load();
		
		rootNode.setCenter(contentView);
	}

	
	@Override
	public void stop() throws Exception {
		super.stop();
	}


	public static void main(String[] args) {
		launch(args);

	}

}
