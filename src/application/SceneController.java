package application;

public class SceneController {
	protected static WindowController windowController;
	protected static String currentUser;
	
	// Set and get windowController
	public static void setWindowController (WindowController windowController) {
		SceneController.windowController = windowController;
	}
	
	public static WindowController getWindowController () {
		return windowController;
	}
	
	// Set and get current userId
	public static void setCurrentUser (String username) {
		if (username != null) {
			currentUser = username;
		} else {
			currentUser = null;
		}
	}
	
	public static String getCurrentUser () {
		return currentUser;
	}
}
