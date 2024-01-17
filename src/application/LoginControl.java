package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginControl extends SubControl {
	@FXML
	TextField usernameIn;
	
	@FXML
	PasswordField passwordIn;

	public void login() {
		
		BackEnd.loginQ(usernameIn.getText(), passwordIn.getText());

		if (SubControl.getCurrentUserId() < 1) {
			/* Fail to login */
			SubControl.setCurrentUserId(-1);
			System.out.println("fail to login");
		} else {
			/* Login successful */
			superControl.changeScene("/MainScene.fxml");
			System.out.println("welcome " + usernameIn.getText() + SubControl.getCurrentUserId());
		}
	}

	public void registering(MouseEvent e) {
		superControl.changeScene("/RegisterScene.fxml");
	}
}
