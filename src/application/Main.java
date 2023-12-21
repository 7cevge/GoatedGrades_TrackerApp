package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, Color.GOLD);

			Image icon;

			icon = new Image(new FileInputStream("./graphics/temporaryIcon.jpg"));
			stage.getIcons().add(icon);
			stage.setTitle("title");
			
			stage.setWidth(720);
			stage.setHeight(480);
			stage.setResizable(true);
			
			stage.setFullScreen(false);
			stage.setFullScreenExitHint("Press Esc to exit full screen");
			stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("esc"));

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
