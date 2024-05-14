package application;

public class GradesController extends SceneController{
	
	/* Return to login screen */
	public void logOut() {
		windowController.changeScene("/LoginScene.fxml");
	}
}
