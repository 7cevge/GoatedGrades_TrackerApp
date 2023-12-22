package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Control {
	@FXML
	private Button minimizeB = new Button();

	@FXML
	private Button maximizeB = new Button();

	@FXML
	private AnchorPane titleBar;
	
	private double windowOffsetX, windowOffsetY;

	public void minimize(ActionEvent e) {
		Stage stage = (Stage) minimizeB.getScene().getWindow();
		stage.setIconified(true);
		System.out.println("window has been minimized");
		System.out.println(e);
	}

	public void maximize(ActionEvent e) {
		Stage stage = (Stage) maximizeB.getScene().getWindow();
		if (stage.isMaximized()) {
			stage.setMaximized(false);
			System.out.println("window has been restored");
		} else {
			stage.setMaximized(true);
			System.out.println("window has been maximized");
		}
		System.out.println(e);
	}

	public void close(ActionEvent e) {
		Platform.exit();
		System.out.println("window has been closed");
		System.out.println(e);
	}

	public void moveWindow1(MouseEvent e) {
		windowOffsetX = e.getSceneX();
	    windowOffsetY = e.getSceneY();
	    System.out.println("titleBar was pressed: " + windowOffsetX + ", " + windowOffsetY);
	    System.out.println(e);
	}

	public void moveWindow2(MouseEvent e) {
		Stage stage = (Stage) titleBar.getScene().getWindow();
	    stage.setX(e.getScreenX() - windowOffsetX);
	    stage.setY(e.getScreenY() - windowOffsetY);
	    System.out.println("titleBar was dragged to: " + stage.getX() + ", " + stage.getY());
	    System.out.println(e);
	}
}
