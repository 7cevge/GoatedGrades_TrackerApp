package application;

import javafx.scene.input.MouseEvent;

public class LoginControl extends SubControl {
	BackEnd backEnd;

	public void login() {
		int userId;
		userId = backEnd.loginQ(null, null);

		if (userId < 1) {
			/* Fail to login */
			SubControl.setCurrentUserId(-1);
		} else {
			/* Login successful */
			SubControl.setCurrentUserId(userId);
		}

		superControl.changeScene("/MainScene.fxml");
	}

	public void registering(MouseEvent e) {
		superControl.changeScene("/RegisterScene.fxml");
	}
}
