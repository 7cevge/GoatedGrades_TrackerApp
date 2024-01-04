package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LoginControl {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void logingIn() {

	}

	public void registering(MouseEvent e) {
		try {
			root = FXMLLoader.load(getClass().getResource("RegisterScene.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/* Sort of importing controls from the window controller */
	FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
	WindowControl windowC = windowLoader.getController();

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
