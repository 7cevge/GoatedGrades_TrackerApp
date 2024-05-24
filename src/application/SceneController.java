package application;

public class SceneController {
	protected static WindowController windowController;
	
	// Set and get windowController
	public static void setWindowController (WindowController windowController) {
		SceneController.windowController = windowController;
	}
	
	public static WindowController getWindowController () {
		return windowController;
	}
	
}
