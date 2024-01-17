package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController extends SubController {
	@FXML
	TextField userNameInput;
	
	@FXML
	PasswordField passwordInput;

	public void logIn() {
		
		BackEnd.loginQ(userNameInput.getText(), passwordInput.getText());

		if (SubController.getCurrentUserId() < 1) {
			/* Fail to login */
			SubController.setCurrentUserId(-1);
			System.out.println("Fail to login");
		} else {
			/* Login successful */
			superController.changeScene("/GradesScene.fxml");
			System.out.println("Welcome " + userNameInput.getText() + SubController.getCurrentUserId());
		}
	}

	public void register(MouseEvent e) {
		superController.changeScene("/RegisterScene.fxml");
	}
}
