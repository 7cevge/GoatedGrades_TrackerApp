package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;

public class DecorControl {
	/* changing scenes */
	
	@FXML
	public ScrollPane contentScreen;
	
	public void changeScene (String fxml) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		try {
			Parent root = loader.load();
			contentScreen.setContent(root);
		} catch (Exception err) {
			System.err.println("there was an error");
		}
	}
}
