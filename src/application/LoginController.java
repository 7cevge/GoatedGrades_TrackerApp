package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LoginController extends SceneController {
	@FXML
	TextField usernameIn;

	@FXML
	Button loginBtn, registerBtn;

	@FXML
	Text noticeText;

	@FXML
	ImageView noticeImg;

	public void login() {
		System.out.println(usernameIn.getText());
		boolean loginOk = Queries.login(usernameIn.getText());

		if (loginOk) {
			// Login successful
			windowController.setCurScene("/GradesScene.fxml");
			windowController.changeScene();
			System.out.println(SceneController.getCurrentUser() + " logged in successfully!");
		} else {
			// Fail to login
			SceneController.setCurrentUser(null);
			loginNotice(true);
			noticeText.setText("Entered username not found, would you like to register this as a new user?");
			
			loginOrReg(false);
		}
	}

	public void register() {
		System.out.println(usernameIn.getText());
		boolean registerOk = Queries.register(usernameIn.getText());

		if (registerOk) {
			// Register successful & login
			System.out.println("reg ok");
			login();

			// Rest login scene
			loginNotice(false);
			loginOrReg(true);

		} else {
			// Fail to register
			SceneController.setCurrentUser(null);
			loginNotice(true);
			noticeText.setText("Invalid Username, please keep it between 2 to 16 charactors.");
		}
		
	}

	public void loginNotice(boolean on) {
		noticeText.setVisible(on);
		noticeImg.setVisible(on);
	}

	private void loginOrReg(Boolean isLogin) {
		loginBtn.setDisable(!isLogin);
		loginBtn.setVisible(isLogin);
		registerBtn.setDisable(isLogin);
		registerBtn.setVisible(!isLogin);
	}
}
