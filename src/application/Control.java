package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Control {
	@FXML
	private Button minimizeB = new Button();
	private Button maximizeB = new Button();
	private Button closeB = new Button();

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
}
