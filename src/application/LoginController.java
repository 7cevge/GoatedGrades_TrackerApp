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
	Button loginBtn, registerBtn, backBtn;

	@FXML
	Text noticeText;

	@FXML
	ImageView noticeImg;

	public void login() {
		boolean loginOk = Queries.login(usernameIn.getText());

		if (loginOk) {
			// Login successful
			windowController.setCurScene("/GradesScene.fxml");
			windowController.changeScene();
		} else {
			// Fail to login
			SceneController.setCurrentUser(null);
			loginNotice(true, 
				"Entered username not found, would you like to register this as a new user?");
			
			loginOrReg(false);
		}
	}

	public void register() {
		boolean registerOk = Queries.register(usernameIn.getText());

		if (registerOk) {
			// Register successful & login
			login();

			// Rest login scene
			loginNotice(false, "");
			loginOrReg(true);

		} else {
			// Fail to register
			SceneController.setCurrentUser(null);
			loginNotice(true, "Invalid Username, please keep it between 2 to 16 charactors.");
		}
	}

	public void back() {
		loginOrReg(true);
	}

	public void loginNotice(boolean on, String msg) {
		noticeText.setVisible(on);
		noticeImg.setVisible(on);
		noticeText.setText(msg);
	}

	private void loginOrReg(Boolean isLogin) {
		usernameIn.setDisable(!isLogin);
		loginBtn.setDisable(!isLogin);
		loginBtn.setVisible(isLogin);
		registerBtn.setDisable(isLogin);
		registerBtn.setVisible(!isLogin);
		backBtn.setDisable(isLogin);
		backBtn.setVisible(!isLogin);
	}
}
