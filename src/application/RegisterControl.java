package application;

import javafx.scene.input.MouseEvent;

public class RegisterControl extends SubControl {
	public void back(MouseEvent e) {
		superControl.changeScene("/LoginScene.fxml");
	}
}
