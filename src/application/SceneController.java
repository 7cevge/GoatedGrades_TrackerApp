package application;

public class SceneController {
	protected static WindowController windowController;
	protected static String currentUser;
	
	/* Set and Get windowController */
	public static void setWindowController (WindowController windowController) {
		SceneController.windowController = windowController;
	}
	
	public static WindowController getWindowController () {
		return windowController;
	}
	
	/* Set and Get current userId */
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
