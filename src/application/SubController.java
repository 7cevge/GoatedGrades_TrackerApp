package application;

public class SubController {
	protected static WindowController superController;
	protected static int currentUserId;
	
	/* Set and Get superController */
	public static void setSuperController (WindowController superController) {
		SubController.superController = superController;
	}
	
	public static WindowController getSuperController () {
		return superController;
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
