package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController extends SceneController {
	@FXML
	TextField userNameInput;
	
	@FXML
	PasswordField passwordInput;

	public void logIn() {
		
		boolean n = Queries.login(userNameInput.getText());

		if (SceneController.getCurrentUser() == null) {
			/* Fail to login */
			SceneController.setCurrentUser(null);
			userNameInput.setText("invalid login");
			passwordInput.clear();
		} else {
			/* Login successful */
			windowController.changeScene("/GradesScene.fxml");
			System.out.println("Welcome " + userNameInput.getText() + SceneController.getCurrentUser());
		}
	}

	public void register(MouseEvent e) {
		windowController.changeScene("/RegisterScene.fxml");
	}
}
