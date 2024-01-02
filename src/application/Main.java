package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		try {
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setMinWidth(300);
			stage.setMinHeight(200);
			stage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
			stage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

			Parent root = FXMLLoader.load(getClass().getResource("/LoginScene.fxml"));
			Scene scene = new Scene(root);
			String windowStyling = this.getClass().getResource("windowStyling.css").toExternalForm();
			scene.getStylesheets().add(windowStyling);

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
