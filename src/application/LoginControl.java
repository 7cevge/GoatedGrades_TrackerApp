package application;

import javafx.scene.input.MouseEvent;

public class LoginControl extends SubControl {

	public void login() {
		
		superControl.changeScene("/MainScene.fxml");
	}

	public void registering(MouseEvent e) {
		superControl.changeScene("/RegisterScene.fxml");
	}
}
