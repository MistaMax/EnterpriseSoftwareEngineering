package proj;

import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
/**
 * Controls the switching between views
 * @author Max Crookshanks
 *
 */
public class ViewSwitcher {
	private static ViewSwitcher instance = null;
	private BorderPane rootNode;
	private static Logger logger = LogManager.getLogger(ViewSwitcher.class);
	
	private ViewSwitcher() {
		rootNode = null;
	}
	
	public void switchView(int viewType, String title) {
		switch(viewType) {
		case 1:
			try {
				logger.info("Switching to Book List View");
				BookListViewController controller = new BookListViewController();
				controller.setRootNode(rootNode);
				
				URL fxmlFile = this.getClass().getResource("BookListView.fxml");
				FXMLLoader loader = new FXMLLoader(fxmlFile);
			
				loader.setController(controller);
			
				Parent contentView = loader.load();

				//get rid of reference to previous content view
				rootNode.setCenter(null);
				
				rootNode.setCenter(contentView);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				logger.info("Switching to Book Detail View");
				BookDetailViewController controller = new BookDetailViewController(title);
				controller.setRootNode(rootNode);
				
				URL fxmlFile = this.getClass().getResource("BookDetailView.fxml");
				FXMLLoader loader = new FXMLLoader(fxmlFile);
			
				loader.setController(controller);
			
				Parent contentView = loader.load();

				//get rid of reference to previous content view
				rootNode.setCenter(null);
				
				rootNode.setCenter(contentView);
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
	}
	
	public BorderPane getRootNode() {
		return rootNode;
	}

	public void setRootNode(BorderPane rootNode) {
		this.rootNode = rootNode;
	}
	
	public Logger getLogger() {
		return logger;
	}

	public static ViewSwitcher getInstance() {
		if(instance == null) {
			instance = new ViewSwitcher();
		}
		return instance;
	}
}
