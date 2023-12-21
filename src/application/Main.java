package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			/*
			 * Text text = new Text(); text.setText("text"); text.setX(25); text.setY(75);
			 * text.setFont(Font.font("MV Boli", 75)); text.setFill(Color.web("0x26619C"));
			 * 
			 * Image icon;
			 * 
			 * icon = new Image(new FileInputStream("./graphics/temporaryIcon.jpg"));
			 * stage.getIcons().add(icon); stage.setTitle("title");
			 * 
			 * stage.setWidth(720); stage.setHeight(480); stage.setResizable(true);
			 * 
			 * stage.setFullScreen(false);
			 * stage.setFullScreenExitHint("Press Esc to exit full screen");
			 * stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("esc"));
			 * 
			 * root.getChildren().add(text);
			 */
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
