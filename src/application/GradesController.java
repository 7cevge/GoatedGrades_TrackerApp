package application;

public class GradesController extends SceneController{
	
	// ------------------------------------------------------------------- The buttons on the left
	public void logout() {
		windowController.setCurScene("/LoginScene.fxml");
		windowController.changeScene();
	}
}
