package application;

public class SubControl {
	protected static WindowControl superControl;
	
	/* Set and Get superController */
	public void setSuperControl (WindowControl superControl) {
		SubControl.superControl = superControl;
	}
	
	public WindowControl getSuperControl () {
		return superControl;
	}
}
