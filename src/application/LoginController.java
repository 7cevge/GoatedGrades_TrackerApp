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
		Estat loginStatus = Queries.login(usernameIn.getText(), userpwIn.getText());

		switch (loginStatus) {
			case Successful:
				windowController.setCurScene("/GradesScene.fxml");
				windowController.changeScene();
				break;

			case UserpwMismatch:
				Start.setCurrentUser(-1);
				loginNotice(true, "Entered username found, but password did not match.");
				break;

			case UserNotFound:
				Start.setCurrentUser(-1);
				loginNotice(true, 
				"Entered username not found, would you like to register this as a new user?");
				loginOrReg(false);
				break;

			default:
				Start.setCurrentUser(-1);
				loginNotice(true, "Unknown error had occurred.");
				break;
		}
	}

	public void register(MouseEvent e) {
		Estat registerStatus = Queries.register(usernameIn.getText(), userpwIn.getText());

		switch (registerStatus) {
			case Successful:
				// Register successful & login
				login(e);

				// Reset login scene
				loginNotice(false, "");
				loginOrReg(true);
				break;
		
			case Invalid:
				Start.setCurrentUser(-1);
				loginNotice(true, "Invalid Username, please keep it between 2 to 16 charactors.");
				break;

			default:
				Start.setCurrentUser(-1);
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
