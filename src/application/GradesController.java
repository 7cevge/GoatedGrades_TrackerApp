package application;

public class GradesController extends SubController{
	
	/* Return to login screen */
	public void logOut() {
		windowController.changeScene("/LoginScene.fxml");
	}
}
