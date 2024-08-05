package application;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradesController extends SceneController {
	@FXML
	private Button logoutBtn;

	@FXML
	private VBox semLst;

	@FXML
    private ScrollPane rightBg;

	public static Map<Node, Obj> compObjMap = new HashMap<Node, Obj>(32);

	// -------------------------------------------------------------------- The buttons on the left
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
	// Load and save functions
	public void load() { 
		// Load in all the data for current user
		System.out.println("hello lol");
		Queries.getAllInfo();
	}

	public void save() {
		//
	}

	// Mapping functions
	public void addToMap(Node componentIn, Obj objIn) {
		compObjMap.put(componentIn, objIn);
	}
	public Obj getObj(Node componentIn) {
		return compObjMap.get(componentIn);
	}

	// Add functions
	public void addSem(MouseEvent e) {
		SemObj newSemObj = newSem();
		semLst.getChildren().add(semLst.getChildren().size() -1, newSemObj.getComponent());
	}

	public void addClass(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent();
		SemObj parent = (SemObj)compObjMap.get(parentComp);
		ClassObj newClassObj = newClass(parent);

		VBox classLst = (VBox) parentSubComp;
		classLst.getChildren().add(classLst.getChildren().size() -1, newClassObj.getComponent());
	}

	public void addPart(MouseEvent e) {}

	public void addGrade(MouseEvent e) {}

	// ----------------------------------------------------------------------------- New components
	private SemObj newSem() {
		Button addClassBtn = new Button("+");
		addClassBtn.setOnMouseClicked(e -> addClass(e));

		VBox classLst = new VBox();
		classLst.setPadding(new Insets(2, 2, 2, 2));
		classLst.getChildren().add(addClassBtn);

		TitledPane newSemComp = new TitledPane("sem", classLst);
		newSemComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newSemComp.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newSemComp.setAnimated(false);

		Obj newSemObj = new SemObj(newSemComp);
		addToMap((Node)newSemComp, newSemObj);

		return (SemObj)newSemObj;
	}

	private ClassObj newClass(SemObj parentIn) {
		Button addPartBtn = new Button("+");
		addPartBtn.setOnMouseClicked(e -> addClass(e));

		VBox partLst = new VBox();
		partLst.setPadding(new Insets(2, 2, 2, 2));
		partLst.getChildren().add(addPartBtn);

		TitledPane newClassComp = new TitledPane("class", partLst);
		newClassComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newClassComp.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newClassComp.setAnimated(false);

		Obj newClassObj = new ClassObj(parentIn, newClassComp);
		addToMap((Node)newClassComp, newClassObj);

		return (ClassObj)newClassObj;
	}
}
