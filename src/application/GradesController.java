package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GradesController extends SceneController{
	@FXML
	private Button logoutBtn;

	@FXML
	private AnchorPane rightContent;

	// -------------------------------------------------------------------------------- Cache data
	private static ArrayList<String> Notes = new ArrayList();

	public static ArrayList<String> getNotes() {
		return null;
	}

	// ------------------------------------------------------------------- The buttons on the left
	public void logout(MouseEvent e) {
		windowController.setCurScene("/LoginScene.fxml");
		windowController.changeScene();
	}

	public void delete(MouseEvent e) {
		Stage popUp = new Stage();
		Start start = new Start();
		start.startPopUp(popUp, "/DeleteScene.fxml");
	}

	public void importData(MouseEvent e) {

	}

	public void exportData(MouseEvent e) {

	}

	// --------------------------------------------------------------------------- Right side stuff

	// Load in all the data for current user
	public void load(MouseEvent e) { 
		// need to change to not a mouseEvent but something called when scene change
		System.out.println("hello lol");
		Queries.getAllInfo();
	}

	// Add functions
	public void addSem(MouseEvent e) {
		System.out.println("clicked on +");
		System.out.println(rightContent.getChildren());
		rightContent.getChildren().add(newSem());
		System.out.println(rightContent.getChildren());
	}

	public void addClass(MouseEvent e) {}

	public void addPart(MouseEvent e) {}

	public void addGrade(MouseEvent e) {}

	// New nodes
	private TitledPane newSem() {
		TitledPane newSem = new TitledPane();
		AnchorPane.setTopAnchor(newSem, 50.0);
		AnchorPane.setLeftAnchor(newSem, 50.0);
		newSem.setPrefSize(200, 150);
		newSem.setAnimated(false);
		return newSem;
	}

	private TitledPane newClass() {
		TitledPane newClass = new TitledPane();
		return newClass;
	}

	private TitledPane newPart() { // maybe not titledpane from this on
		TitledPane newClass = new TitledPane();
		return null;
	}
}
