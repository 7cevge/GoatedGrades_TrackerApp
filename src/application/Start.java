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
			Scene scene = new Scene(root);

			// Set up the controls and scene styling
			SceneController.setWindowController(loader.getController());

			String windowStyling = this.getClass().getResource("../css/windowStyling.css").toExternalForm();
			scene.getStylesheets().add(windowStyling);

			// Display the window
			stage.setScene(scene);
			stage.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
