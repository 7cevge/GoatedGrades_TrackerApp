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

	private double newX = -1, newY = -1;

	public void minimize(ActionEvent e) {
		Stage stage = (Stage) minimizeB.getScene().getWindow();
		stage.setIconified(true);
		System.out.println("window minimized");
	}

	public void maximize(ActionEvent e) {
		Stage stage = (Stage) maximizeB.getScene().getWindow();
		if (stage.isMaximized()) {
			stage.setMaximized(false);
			System.out.println("window restored");
		} else {
			stage.setMaximized(true);
			System.out.println("window maximized");
		}
	}

	public void close(ActionEvent e) {
		Platform.exit();
		System.out.println("window closed");
	}

	public void moveWindow1(MouseEvent e) {
		String target = e.getTarget().toString();
		if (target.contains("Rectangle")) {
		} else {
			newX = e.getSceneX();
			newY = e.getSceneY();
			System.out.println("titleBar init: " + newX + ", " + newY);
		}
	}

	public void moveWindow2(MouseEvent e) {
		String target = e.getTarget().toString();
		Stage stage = (Stage) titleBar.getScene().getWindow();
		if (target.contains("Rectangle")) {
		} else if (newX != -1 && newY != -1) {
			stage.setX(e.getScreenX() - newX);
			stage.setY(e.getScreenY() - newY);
			System.out.println("titleBar was dragged to: " + stage.getX() + ", " + stage.getY());
		} else {
			System.err.println("invalid newX and or newY");
		}
	}

	public void resizeWindow1(MouseEvent e) {
		String target = e.getTarget().toString();
		if (target.contains("id=TLrs") || target.contains("id=Trs") || target.contains("TRrs")
				|| target.contains("id=SRrs") || target.contains("id=Rrs") || target.contains("id=BRrs")
				|| target.contains("id=Brs") || target.contains("id=BLrs") || target.contains("id=Lrs")
				|| target.contains("id=SLrs")) {
			newX = e.getSceneX();
			newY = e.getSceneY();
			System.out.println("resize init: " + newX + ", " + newY);
			System.out.println(e.getTarget());
		}
		System.out.println("resize");
	}

	public void resizeWindow2(MouseEvent e) {
		Stage stage = (Stage) titleBar.getScene().getWindow();
		if (newX != -1 && newY != -1) {
			switch (e.getTarget().toString().substring(10, 17)) {
			case "id=TRrs":
				//
				break;
			case "":
				//
				/*
				 * stage.setX(e.getScreenX() - newX); stage.setY(e.getScreenY() - newY);
				 * System.out.println(e); System.out.println(e.getTarget());
				 */
			}
		} else {
			System.err.println("invalid newX and or newY");
		}
	}
}
