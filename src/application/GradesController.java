package application;

import javafx.stage.Stage;

public class GradesController extends SceneController{
	
	// ------------------------------------------------------------------- The buttons on the left
	public void logout() {
		windowController.setCurScene("/LoginScene.fxml");
		windowController.changeScene();
	}

	public void delete() {
		Stage popUp = new Stage();
		Start start = new Start();
		start.startPopUp(popUp, "/DeleteScene.fxml");
	}
}
