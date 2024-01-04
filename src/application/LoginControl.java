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

	public void minimize(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.minimize(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void maximize(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.maximize(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void close(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.close(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void moveWindow1(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.moveWindow1(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void moveWindow2(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.moveWindow2(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void resizeWindow1(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.resizeWindow1(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void resizeWindow2(MouseEvent e) {
		try {
			FXMLLoader windowLoader = new FXMLLoader(getClass().getResource("WindowScene.fxml"));
			root = windowLoader.load();
			WindowControl windowC = windowLoader.getController();
			windowC.resizeWindow2(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
