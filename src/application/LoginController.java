package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LoginController extends SceneController {
	@FXML
	TextField usernameIn;

	@FXML
	PasswordField userpwIn;

	@FXML
	Button loginBtn, registerBtn, backBtn;

	@FXML
	Text noticeText;

	@FXML
	ImageView noticeImg;

	public void login(MouseEvent e) {
		int loginStatus = Queries.login(usernameIn.getText(), userpwIn.getText());

		switch (loginStatus) {
			case 0:
				// Login successful
				windowController.setCurScene("/GradesScene.fxml");
				windowController.changeScene();
				break;

			case 1:
				// Username found, but userpw mismatch
				Start.setCurrentUser(0);

				loginNotice(true, "Entered username found, but password did not match.");
				break;

			case 2:
				// Username not found
				Start.setCurrentUser(0);
				
				loginNotice(true, 
				"Entered username not found, would you like to register this as a new user?");
				loginOrReg(false);
				break;

			default:
				// Unknown Error
				Start.setCurrentUser(0);

				loginNotice(true, "Unknown error had occurred.");
				break;
		}
	}

	public void register(MouseEvent e) {
		int registerStatus = Queries.register(usernameIn.getText(), userpwIn.getText());

		switch (registerStatus) {
			case 0:
				// Register successful & login
				login(e);

				// Reset login scene
				loginNotice(false, "");
				loginOrReg(true);
				break;
		
			case 1:
				// Invalid new username
				Start.setCurrentUser(0);
				loginNotice(true, "Invalid Username, please keep it between 2 to 16 charactors.");
				break;

			default:
				Start.setCurrentUser(0);
				loginNotice(true, "Unknown error has occurred.");
				break;
		}
	}

	public void back(MouseEvent e) {
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
