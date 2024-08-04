package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradesController extends SceneController{
	@FXML
	private Button logoutBtn;

	@FXML
	private VBox semLst;

	@FXML
    private ScrollPane rightBg;

	// -------------------------------------------------------------------------------- Cache data

	private static ArrayList<SemObj> casheSemLst = new ArrayList<SemObj>(8);

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
	public void load() { 
		// Load in all the data for current user
		System.out.println("hello lol");
		Queries.getAllInfo();
	}

	// Add functions
	public void addSem(MouseEvent e) {
		semLst.getChildren().add(semLst.getChildren().size() -1, newSem());
	}

	public void addClass(MouseEvent e) {
		//classLst.getChildren().add(semLst.getChildren().size() -1, newSem());
	}

	public void addPart(MouseEvent e) {}

	public void addGrade(MouseEvent e) {}

	// ----------------------------------------------------------------------------- New components
	private TitledPane newSem() {
		Button addClassBtn = new Button("+");
		addClassBtn.setOnMouseClicked(e -> addClass(e));

		VBox classLst = new VBox();
		classLst.setPadding(new Insets(2, 2, 2, 2));
		classLst.getChildren().add(addClassBtn);

		TitledPane newSem = new TitledPane("sem", classLst);
		newSem.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newSem.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newSem.setAnimated(false);
		return newSem;
	}

	private TitledPane newClass() {
		Button addPartBtn = new Button("+");
		addPartBtn.setOnMouseClicked(e -> addClass(e));

		VBox partLst = new VBox();
		partLst.setPadding(new Insets(2, 2, 2, 2));
		partLst.getChildren().add(addPartBtn);

		TitledPane newClass = new TitledPane("class", partLst);
		newClass.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newClass.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newClass.setAnimated(false);
		return newClass;
	}
}
