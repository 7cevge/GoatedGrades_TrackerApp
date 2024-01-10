package application;

public class MainControl extends SubControl{
	
	/* Return to login screen */
	public void logout() {
		superControl.changeScene("/LoginScene.fxml");
	}
}
