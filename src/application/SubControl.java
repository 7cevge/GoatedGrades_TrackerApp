package application;

public class SubControl {
	protected static WindowControl superControl;
	
	public void setSuperControl (WindowControl superControl) {
		SubControl.superControl = superControl;
	}
	
	public WindowControl getSuperControl () {
		return superControl;
	}
}
