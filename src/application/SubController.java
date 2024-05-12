package application;

public class SubController {
	protected static WindowController windowController;
	protected static int currentUserId;
	
	/* Set and Get windowController */
	public static void setWindowController (WindowController windowController) {
		SubController.windowController = windowController;
	}
	
	public static WindowController getWindowController () {
		return windowController;
	}
	
	/* Set and Get current userId */
	public static void setCurrentUserId (int id) {
		if (id < 1) {
			currentUserId = -1;
		} else {
			currentUserId = id;
		}
	}
	
	public static int getCurrentUserId () {
		return currentUserId;
	}
}
