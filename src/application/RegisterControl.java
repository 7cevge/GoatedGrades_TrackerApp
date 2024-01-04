package application;

import javafx.scene.input.MouseEvent;

public class RegisterControl {
	/* Sort of importing controls from the window controller */
	WindowControl windowC = new WindowControl();

	public void minimize(MouseEvent e) {
		windowC.minimize(e);
	}

	public void maximize(MouseEvent e) {
		windowC.maximize(e);
	}

	public void close(MouseEvent e) {
		windowC.close(e);
	}

	public void moveWindow1(MouseEvent e) {
		windowC.moveWindow1(e);
	}

	public void moveWindow2(MouseEvent e) {
		windowC.moveWindow2(e);
	}

	public void resizeWindow1(MouseEvent e) {
		windowC.resizeWindow1(e);
	}

	public void resizeWindow2(MouseEvent e) {
		windowC.resizeWindow2(e);
	}
}
