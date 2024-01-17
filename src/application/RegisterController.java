package application;

import javafx.scene.input.MouseEvent;

public class RegisterController extends SubController {
	
	/* Return to login scene */
	public void backOut(MouseEvent e) {
		superController.changeScene("/LoginScene.fxml");
	}
}
