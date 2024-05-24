package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	// ------------------------------------------------------------ Static / application variables
	private static String currentUser;
	private static ArrayList<WindowController> windowLst = new ArrayList<>(3);

	// Set and get current userId
	public static void setCurrentUser(String username) {
		if (username != null) {
			currentUser = username;
		} else {
			currentUser = null;
		}
	}
	public static String getCurrentUser() {
		return currentUser;
	}

	// Functions for windowLst
	public static void addToWindowLst(WindowController newWindow) {
		windowLst.add(newWindow);
	}
	public static WindowController getFromWindowLst(int negIndex) {
		// negIndex is position from the end of the lst
		try {
			return windowLst.get(windowLst.size() - 1 - negIndex);
		} catch (Exception err) {
			return null;
		}
	}
	public static void delFromWindowLst(WindowController delWindow) {
		try {
			windowLst.remove(delWindow);
			getFromWindowLst(0).disable(false);
		} catch (Exception err) {}
	}
	public static ArrayList<WindowController> getWindowLst() {
		return windowLst;
	}

	// -------------------------------------------------------------------------------------------
	public void start(Stage stage) {
		try {
			// Set up for personal window styling
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setMinWidth(620);
			stage.setMinHeight(380);
			stage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
			stage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

			// Load the window
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WindowStage.fxml"));
			Parent root = loader.load();
			Scene windowScene = new Scene(root);

			// Set up the controls and scene styling
			addToWindowLst(loader.getController());
			SceneController.setWindowController(getFromWindowLst(0));

			// Display the window
			stage.setScene(windowScene);
			stage.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}

	public void startPopUp(Stage stage, String sceneIn) {
		try {
			// Set up for personal window styling
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
			stage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

			int width, height;
			switch (sceneIn) {
				case "/DeleteScene.fxml":
					width = 200;
					height = 120;
					break;
				default:
					width = 620;
					height = 380;
					break;
			}

			stage.setMinWidth(width);
			stage.setMinHeight(height);
			stage.setWidth(width);
			stage.setHeight(height);

			// Load the window
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WindowStage.fxml"));
			Parent root = loader.load();
			Scene windowScene = new Scene(root);

			// Set up the controls and scene styling
			addToWindowLst(loader.getController());
			SceneController.setWindowController(getFromWindowLst(0));
			WindowController popUpController = loader.getController();
			popUpController.setCurScene(sceneIn);
			popUpController.changeScene();

			// Disable previous window
			getFromWindowLst(1).disable(true);

			// Display the window
			stage.setScene(windowScene);
			stage.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
