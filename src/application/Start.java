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
	private static int currentUser;
	private static ArrayList<WindowController> windowLst = new ArrayList<>(3);
	private static Stage mainStage;

	// Set and get current userId
	public static void setCurrentUser(int userId) {
		if (userId != 0) {
			currentUser = userId;
		} else {
			currentUser = 0;
		}
	}
	public static int getCurrentUser() {
		return currentUser;
	}

	// Get mainStage
	public static Stage getMainStage() {
		return mainStage;
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
			mainStage = stage;

			// Set up for personal window styling
			mainStage.initStyle(StageStyle.UNDECORATED);
			mainStage.setMinWidth(620);
			mainStage.setMinHeight(380);
			mainStage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
			mainStage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

			// Load the window
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WindowStage.fxml"));
			Parent root = loader.load();
			Scene windowScene = new Scene(root);

			// Set up the controls and scene styling
			addToWindowLst(loader.getController());
			SceneController.setWindowController(getFromWindowLst(0));

			// Display the window
			mainStage.setScene(windowScene);
			mainStage.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}

	public void startPopUp(Stage popUp, String sceneIn) {
		try {
			// Set up for personal window styling
			popUp.initStyle(StageStyle.UNDECORATED);
			popUp.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
			popUp.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

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

			popUp.setMinWidth(width);
			popUp.setMinHeight(height);
			popUp.setWidth(width);
			popUp.setHeight(height);

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

			// Disable previous window and lock popUp on top
			getFromWindowLst(1).disable(true);
			popUp.initOwner(mainStage);

			// Display the window
			popUp.setScene(windowScene);
			popUp.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
