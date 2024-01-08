package application;

public class MainControl extends SubControl{
	public void logout() {
		superControl.changeScene("/LoginScene.fxml");
	}
}
