package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
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
	public static void load() { 
		System.out.println("load");
		List<ArrayList<String[]>> allData = Queries.getLoadData();

		// test
		for (int i = 0; i < 4; i++) {
			switch (i) {
				case 0:
					System.out.println("Sems:");
					break;
				case 1:
					System.out.println("Classes:");
					break;
				case 2:
					System.out.println("Parts:");
					break;
				case 3:
					System.out.println("Sems:");
					break;
				default:
					break;
			}
			ArrayList<String[]> tableData = allData.get(i);
			for (String[] rowData : tableData) {
				for (String data : rowData) {
					System.out.print(data + " ");
				}
				System.out.println("");
			}
		}
	}

	public static void save() {
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
		int newOrder = semLst.getChildren().size();

		SemObj newSemObj = newSem(newOrder);
		semLst.getChildren().add(semLst.getChildren().size() -1, newSemObj.getComponent());
	}

	public void addClass(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent();
		SemObj parent = (SemObj)compObjMap.get(parentComp);

		VBox classLst = (VBox) parentSubComp;
		int newOrder = classLst.getChildren().size();
		ClassObj newClassObj = newClass(newOrder, parent);

		classLst.getChildren().add(classLst.getChildren().size() -1, newClassObj.getComponent());
	}

	public void addPart(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent();
		ClassObj parent = (ClassObj)compObjMap.get(parentComp);

		VBox partLst = (VBox) parentSubComp;
		int newOrder = partLst.getChildren().size();
		PartObj newPartObj = newPart(newOrder, parent);

		partLst.getChildren().add(partLst.getChildren().size() -2, newPartObj.getComponent());
	}

	public void addGrade(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent();
		PartObj parent = (PartObj)compObjMap.get(parentComp);
		
		HBox gradeLst = (HBox) parentSubComp;
		int newOrder = gradeLst.getChildren().size();
		GradeObj newGradeObj = newGrade(newOrder, parent);

		gradeLst.getChildren().add(gradeLst.getChildren().size() -1, newGradeObj.getComponent());
	}

	// ----------------------------------------------------------------------------- New components
	private SemObj newSem(int semOrderIn) {
		// Comp
		Button addClassBtn = new Button("+");
		addClassBtn.setOnMouseClicked(e -> addClass(e));

		VBox classLst = new VBox();
		classLst.setPadding(new Insets(2, 2, 2, 2));
		classLst.getChildren().add(addClassBtn);

		TitledPane newSemComp = new TitledPane("sem", classLst);
		newSemComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newSemComp.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newSemComp.setAnimated(false);

		// Obj
		Obj newSemObj = new SemObj(semOrderIn, newSemComp);
		addToMap((Node)newSemComp, newSemObj);

		return (SemObj)newSemObj;
	}

	private ClassObj newClass(int classOrderIn, SemObj parentIn) {
		// Comp
		Button addPartBtn = new Button("+");
		addPartBtn.setOnMouseClicked(e -> addPart(e));

		HBox classStat = newClassStat();

		VBox partLst = new VBox();
		partLst.setPadding(new Insets(2, 2, 2, 2));
		partLst.getChildren().addAll(addPartBtn, classStat);
		partLst.getStyleClass().add("inClass");

		TitledPane newClassComp = new TitledPane("class", partLst);
		newClassComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newClassComp.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newClassComp.setAnimated(false);

		// Obj
		Obj newClassObj = new ClassObj(classOrderIn, parentIn, newClassComp);
		addToMap((Node)newClassComp, newClassObj);

		return (ClassObj)newClassObj;
	}

	private PartObj newPart(int partOrderIn, ClassObj parentIn) {
		// Comp
		AnchorPane partStat = newPartStat();
		ScrollPane gradeSect = newGradeSect();

		HBox newPartComp = new HBox();
		newPartComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newPartComp.getChildren().addAll(partStat, gradeSect);

		gradeSect.prefWidthProperty().bind(newPartComp.widthProperty());
		
		// Obj
		Obj newPartObj = new PartObj(partOrderIn, parentIn, newPartComp);
		addToMap((Node)newPartComp, newPartObj);

		return (PartObj)newPartObj;
	}

	private GradeObj newGrade(int gradeOrderIn, PartObj parentIn) {
		// Comp
		TextField got = newMiniTextField(35, 15, Pos.CENTER_RIGHT);
		got.setPromptText("100");
		TextField outOf = newMiniTextField(35, 15, Pos.CENTER_RIGHT);
		outOf.setPromptText("100");

		Label gradePercent = new Label("00.00%");
		gradePercent.getStyleClass().add("gradePercent");
		gradePercent.setPrefWidth(40);
		gradePercent.setTextAlignment(TextAlignment.RIGHT);

		Button toggleEst = new Button(); // <----------------------------------------------------------------- NOT DONE YET!
		toggleEst.setPrefHeight(15);
		toggleEst.setMinHeight(15);
		toggleEst.setPrefWidth(15);

		AnchorPane newGradeComp = new AnchorPane();
		newGradeComp.setPrefSize(40, 30);
		newGradeComp.getChildren().addAll(toggleEst, got, outOf, gradePercent);

		got.setLayoutX(5);
		outOf.setLayoutX(5);
		outOf.setLayoutY(15);
		gradePercent.setLayoutY(30);

		// Obj
		Obj newGradeObj = new GradeObj(gradeOrderIn, parentIn, newGradeComp);
		addToMap((Node)newGradeComp, newGradeObj);

		return (GradeObj)newGradeObj;
	}

	// ----------------------------------------------------------------- Component helper functions
	private HBox newClassStat() {
		// In threshold
		Label thresholdLabel = new Label("A >		%\nB >		%\nC >		%");

		TextField thresholdA = newMiniTextField(40, 15, Pos.CENTER_RIGHT);
		TextField thresholdB = newMiniTextField(40, 15, Pos.CENTER_RIGHT);
		TextField thresholdC = newMiniTextField(40, 15, Pos.CENTER_RIGHT);

		VBox thresholdABC = new VBox();
		thresholdABC.setLayoutX(10);
		thresholdABC.getChildren().addAll(thresholdA, thresholdB, thresholdC);

		// In actualGrade
		Label actualGradeLabel = new Label("Est: A\nAct:");

		ChoiceBox<Character> actualGrade = new ChoiceBox<Character>();
		actualGrade.setPrefSize(25, 20);
		actualGrade.setMinSize(25, 20);
		actualGrade.setLayoutX(12);
		actualGrade.setLayoutY(12);
		actualGrade.getItems().addAll('A', 'B', 'C', 'D', 'F', '-');
		actualGrade.getSelectionModel().selectedItemProperty().addListener(e -> {
            actualGrade.lookup(".arrow").setVisible(false);
        });

		// In classStat 
		Label classCalc = new Label("          Total\nPoint:    000.0%\nPercent: 000.0%");
		classCalc.setPrefSize(72, 45);
		classCalc.setMinSize(72, 45);

		AnchorPane thresholdSect = new AnchorPane();
		thresholdSect.setPrefHeight(35);
		thresholdSect.setPrefWidth(45);
		thresholdSect.getChildren().addAll(thresholdLabel, thresholdABC);

		AnchorPane actualGradeSect = new AnchorPane();
		actualGradeSect.setPrefHeight(35);
		actualGradeSect.setPrefWidth(45);
		actualGradeSect.getChildren().addAll(actualGradeLabel, actualGrade);

		TextArea classNote = new TextArea("NOTES");
		classNote.setWrapText(true);

		// ClassStat
		HBox classStat = new HBox(5);
		classStat.setPrefHeight(45);
		classStat.getChildren().addAll(classCalc, thresholdSect, actualGradeSect, classNote);

		classNote.prefWidthProperty().bind(classStat.widthProperty());

		return classStat;
	}

	private TextField newMiniTextField(int width, int height, Pos alignment) {
		TextField miniText = new TextField();
		miniText.setPrefWidth(width);
		miniText.setPrefHeight(height);
		miniText.setMinHeight(height);
		miniText.setAlignment(alignment);
		return miniText;
	}

	private AnchorPane newPartStat() {
		TextField partName = new TextField("Exam");
		partName.setPrefHeight(15);
		partName.setMinHeight(15);
		partName.setPrefWidth(95);
		partName.setAlignment(Pos.CENTER);

		TextField partPercent = new TextField("25.5");
		partPercent.setPrefHeight(15);
		partPercent.setMinHeight(15);
		partPercent.setPrefWidth(32);
		partPercent.setAlignment(Pos.CENTER_RIGHT);

		Label partCalc = new Label("					    %\nPoint:     000.0% | 000.0%\nPercent: 000.0% | 000.0%");

		AnchorPane partStat = new AnchorPane();
		partStat.setPrefWidth(100);
		partStat.setPrefHeight(60);
		partStat.getChildren().addAll(partCalc, partName, partPercent);

		partPercent.setLayoutX(partName.getPrefWidth());

		return partStat;
	}

	private ScrollPane newGradeSect() {
		Button addGradeBtn = new Button("+");
		addGradeBtn.setOnMouseClicked(e -> addGrade(e));

		HBox gradeLst = new HBox(2);
		gradeLst.setPadding(new Insets(2, 2, 2, 2));
		gradeLst.getChildren().add(addGradeBtn);

		ScrollPane gradeSect = new ScrollPane(gradeLst);
		gradeSect.setVbarPolicy(ScrollBarPolicy.NEVER);
		gradeSect.setHbarPolicy(ScrollBarPolicy.ALWAYS);

		return gradeSect;
	}
}
