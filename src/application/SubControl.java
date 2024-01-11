package application;

public class SubControl {
	protected static WindowControl superControl;
	protected static int currentUserId;
	
	/* Set and Get superController */
	public static void setSuperControl (WindowControl superControl) {
		SubControl.superControl = superControl;
	}
	
	public static WindowControl getSuperControl () {
		return superControl;
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
