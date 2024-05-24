package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GradesController extends SceneController{
	@FXML
	private Button logoutBtn;

	// ------------------------------------------------------------------- The buttons on the left
	public void logout(MouseEvent e) {
		windowController.setCurScene("/LoginScene.fxml");
		windowController.changeScene();
	}

	public void delete(MouseEvent e) {
		Stage popUp = new Stage();
		Start start = new Start();
		start.startPopUp(popUp, "/DeleteScene.fxml");
	}
}
