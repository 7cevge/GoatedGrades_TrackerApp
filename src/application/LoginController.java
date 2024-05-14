package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController extends SceneController {
	@FXML
	TextField usernameIn;

	public void logIn() {
		
		boolean loginOk = Queries.login(usernameIn.getText());

		if (loginOk) {
			// Login successful
			windowController.changeScene("/GradesScene.fxml");
			System.out.println("Welcome " + usernameIn.getText() + SceneController.getCurrentUser());
		} else {
			// Fail to login
			SceneController.setCurrentUser(null);
			usernameIn.setText("invalid login");
		}
	}
}
