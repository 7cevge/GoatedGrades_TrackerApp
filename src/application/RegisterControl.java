package application;

import javafx.scene.input.MouseEvent;

public class RegisterControl extends SubControl {
	
	/* Return to login scene */
	public void back(MouseEvent e) {
		superControl.changeScene("/LoginScene.fxml");
	}
}
