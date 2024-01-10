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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WindowScene.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			/* Set up the controls and scene styling */
			SubControl subControl = new SubControl();
			subControl.setSuperControl(loader.getController());
			
			String windowStyling = this.getClass().getResource("windowStyling.css").toExternalForm();
			scene.getStylesheets().add(windowStyling);

			/* Display the window */
			stage.setScene(scene);
			stage.show();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
