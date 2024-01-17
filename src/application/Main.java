package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		try {
			/* Set up for personal window styling */
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setMinWidth(600);
			stage.setMinHeight(400);
			stage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
			stage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

			/* Load the window */
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WindowStage.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);

			/* Set up the controls and scene styling */
			SubController.setSuperController(loader.getController());

			String windowStyling = this.getClass().getResource("windowStyling.css").toExternalForm();
			scene.getStylesheets().add(windowStyling);

			/* Display the window */
			stage.setScene(scene);
			stage.show();
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
