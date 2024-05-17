package application;

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
			SceneController.setWindowController(loader.getController());

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
			SceneController.setWindowController(loader.getController());

			WindowController popUpController = loader.getController();
			popUpController.setCurScene(sceneIn);
			popUpController.changeScene();

			// Display the window
			stage.setScene(windowScene);
			stage.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
