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
	public static Map<String, Obj> fkObjMap = new HashMap<String, Obj>(32);

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

	// -------------------------------------------------------------------------- Right side stuff
	// Load and save functions
	public void load() {
		List<ArrayList<String[]>> allData = Queries.getLoadData();

		for (int i = 0; i < 4; i++) {
			ArrayList<String[]> tableData = allData.get(i);
			for (String[] rowData : tableData) {
				switch (i) {
					case 0:
						loadSem(rowData);
						break;
					case 1:
						SemObj parentSem = (SemObj)getFromFkObj("sem" + rowData[rowData.length -1]);
						loadClass(rowData, parentSem);
						break;
					case 2:
						ClassObj parentClass = (ClassObj)getFromFkObj("class" + rowData[rowData.length -1]);
						loadPart(rowData, parentClass);
						break;
					case 3:
						PartObj parentPart = (PartObj)getFromFkObj("part" + rowData[rowData.length -1]);
						loadGrade(rowData, parentPart);
						break;
					default:
						break;
				}
			}
		}
	}

	public static void save() {
		//
	}

	// Mapping functions
	public void addToCompObj(Node componentIn, Obj objIn) {
		compObjMap.put(componentIn, objIn);
	}
	public Obj getFromCompObj(Node componentIn) {
		return compObjMap.get(componentIn);
	}

	public void addToFkObj(String fkIn, Obj objIn) {
		fkObjMap.put(fkIn, objIn);
	}
	public Obj getFromFkObj(String fkIn) {
		return fkObjMap.get(fkIn);
	}

	// Add functions
	public void addSem(MouseEvent e) {
		int newOrder = semLst.getChildren().size();

		SemObj newSemObj = newSem(newOrder);
		semLst.getChildren().add(semLst.getChildren().size() -1, newSemObj.getComponent());
	}

	public void addClass(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent().getParent();
		SemObj parent = (SemObj)compObjMap.get(parentComp);

		VBox classLst = (VBox) parentSubComp;
		int newOrder = classLst.getChildren().size();
		ClassObj newClassObj = newClass(newOrder, parent);

		classLst.getChildren().add(classLst.getChildren().size() -1, newClassObj.getComponent());
	}

	public void addPart(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent().getParent();
		ClassObj parent = (ClassObj)compObjMap.get(parentComp);

		VBox partLst = (VBox) parentSubComp;
		int newOrder = partLst.getChildren().size();
		PartObj newPartObj = newPart(newOrder, parent);

		partLst.getChildren().add(partLst.getChildren().size() -2, newPartObj.getComponent());
	}

	public void addGrade(MouseEvent e) {
		Node parentSubComp = ((Node)e.getSource()).getParent();
		Node parentComp = parentSubComp.getParent().getParent().getParent().getParent();
		PartObj parent = (PartObj)compObjMap.get(parentComp);

		HBox gradeLst = (HBox) parentSubComp;
		int newOrder = gradeLst.getChildren().size();
		GradeObj newGradeObj = newGrade(newOrder, parent);

		gradeLst.getChildren().add(gradeLst.getChildren().size() -1, newGradeObj.getComponent());
	}

	// ---------------------------------------------------------------------------- New components
	// Sem component
	private SemObj newSem(int semOrderIn) {
		TitledPane newSemComp = newSemComp();

		Obj newSemObj = new SemObj(semOrderIn, newSemComp);
		addToCompObj((Node)newSemComp, newSemObj);

		return (SemObj)newSemObj;
	}
	private void loadSem(String[] rowDataIn) {
		TitledPane newSemComp = newSemComp();

		boolean[] isStringLst = {false, true, true, false, false};
		replaceAllNull(rowDataIn, isStringLst);

		Obj newSemObj = new SemObj(Integer.parseInt(rowDataIn[0]), rowDataIn[1], rowDataIn[2], 
					Integer.parseInt(rowDataIn[3]), newSemComp);
		addToCompObj((Node)newSemComp, newSemObj);
		addToFkObj("sem" + rowDataIn[0], newSemObj);

		semLst.getChildren().add(semLst.getChildren().size() -1, ((SemObj)newSemObj).getComponent());
	}
	private TitledPane newSemComp() {
		Button addClassBtn = new Button("+");
		addClassBtn.setOnMouseClicked(e -> addClass(e));

		VBox classLst = new VBox();
		classLst.setPadding(new Insets(2, 2, 2, 24));
		classLst.getChildren().add(addClassBtn);

		TitledPane newSemComp = new TitledPane("", classLst);
		newSemComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newSemComp.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newSemComp.setAnimated(false);

		return newSemComp;
	}

	// Class component
	private ClassObj newClass(int classOrderIn, SemObj parentIn) {
		TitledPane newClassComp = newClassComp();

		Obj newClassObj = new ClassObj(classOrderIn, parentIn, newClassComp);
		addToCompObj((Node)newClassComp, newClassObj);

		return (ClassObj)newClassObj;
	}
	private void loadClass(String[] rowDataIn, SemObj parentIn) {
		TitledPane newClassComp = newClassComp();

		boolean[] isStringLst = {false, true, true, false, false, false, false, true, true, false,
					false};
		replaceAllNull(rowDataIn, isStringLst);

		Obj newClassObj = new ClassObj(Integer.parseInt(rowDataIn[0]), rowDataIn[1], rowDataIn[2], 
					Double.parseDouble(rowDataIn[3]), Double.parseDouble(rowDataIn[4]), 
					Double.parseDouble(rowDataIn[5]), Double.parseDouble(rowDataIn[6]), 
					rowDataIn[7], rowDataIn[8], Integer.parseInt(rowDataIn[9]), 
					Integer.parseInt(rowDataIn[10]), parentIn, newClassComp);
		addToCompObj((Node)newClassComp, newClassObj);
		addToFkObj("class" + rowDataIn[0], newClassObj);

		Node compLst = getCompLst(newClassObj, Estat.Class);
		VBox classLst = (VBox) compLst;
		classLst.getChildren().add(
					classLst.getChildren().size() -1, ((ClassObj)newClassObj).getComponent());
	}
	private TitledPane newClassComp() {
		Button addPartBtn = new Button("+");
		addPartBtn.setOnMouseClicked(e -> addPart(e));

		HBox classStat = newClassStat();

		VBox partLst = new VBox();
		partLst.setPadding(new Insets(2, 2, 2, 2));
		partLst.getChildren().addAll(addPartBtn, classStat);
		partLst.getStyleClass().add("inClass");

		TitledPane newClassComp = new TitledPane("", partLst);
		newClassComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newClassComp.setPrefHeight(Region.USE_COMPUTED_SIZE);
		newClassComp.setAnimated(false);

		return newClassComp;
	}

	// Part component
	private PartObj newPart(int partOrderIn, ClassObj parentIn) {
		HBox newPartComp = newPartComp();
		
		Obj newPartObj = new PartObj(partOrderIn, parentIn, newPartComp);
		addToCompObj((Node)newPartComp, newPartObj);

		return (PartObj)newPartObj;
	}
	private void loadPart(String[] rowDataIn, ClassObj parentIn) {
		HBox newPartComp = newPartComp();

		boolean[] isStringLst = {false, true, false, true, false, false};
		replaceAllNull(rowDataIn, isStringLst);
		
		Obj newPartObj = new PartObj(Integer.parseInt(rowDataIn[0]), rowDataIn[1], 
					Double.parseDouble(rowDataIn[2]), rowDataIn[3], 
					Integer.parseInt(rowDataIn[4]), Integer.parseInt(rowDataIn[5]), parentIn, 
					newPartComp);
		addToCompObj((Node)newPartComp, newPartObj);
		addToFkObj("part" + rowDataIn[0], newPartObj);

		Node compLst = getCompLst(newPartObj, Estat.Part);
		VBox partLst = (VBox) compLst;
		partLst.getChildren().add(
					partLst.getChildren().size() -2, ((PartObj)newPartObj).getComponent());
	}
	private HBox newPartComp() {
		AnchorPane partStat = newPartStat();
		ScrollPane gradeSect = newGradeSect();

		HBox newPartComp = new HBox();
		newPartComp.prefWidthProperty().bind(rightBg.widthProperty().subtract(30));
		newPartComp.getChildren().addAll(partStat, gradeSect);

		gradeSect.prefWidthProperty().bind(newPartComp.widthProperty());

		return newPartComp;
	}

	// Grade component
	private GradeObj newGrade(int gradeOrderIn, PartObj parentIn) {
		AnchorPane newGradeComp = newGradeComp();

		Obj newGradeObj = new GradeObj(gradeOrderIn, parentIn, newGradeComp);
		addToCompObj((Node)newGradeComp, newGradeObj);

		return (GradeObj)newGradeObj;
	}
	private void loadGrade(String[] rowDataIn, PartObj parentIn) {
		AnchorPane newGradeComp = newGradeComp();

		boolean[] isStringLst = {false, false, false, false, false, true, false, false, false, 
					false, false, false};
		replaceAllNull(rowDataIn, isStringLst);

		Obj newGradeObj = new GradeObj(Integer.parseInt(rowDataIn[0]), 
					Double.parseDouble(rowDataIn[1]), Double.parseDouble(rowDataIn[2]), 
					Double.parseDouble(rowDataIn[3]), Double.parseDouble(rowDataIn[4]), 
					rowDataIn[5], Integer.parseInt(rowDataIn[6]), Integer.parseInt(rowDataIn[7]), 
					Integer.parseInt(rowDataIn[8]), Integer.parseInt(rowDataIn[9]), 
					Integer.parseInt(rowDataIn[10]), Integer.parseInt(rowDataIn[11]), parentIn, 
					newGradeComp);
		addToCompObj((Node)newGradeComp, newGradeObj);
		addToFkObj("grade" + rowDataIn[0], newGradeObj);

		Node compLst = getCompLst(newGradeObj, Estat.Grade);
		HBox gradeLst = (HBox) compLst;
		gradeLst.getChildren().add(
					gradeLst.getChildren().size() -1, ((GradeObj)newGradeObj).getComponent());
	}
	private AnchorPane newGradeComp() {
		TextField got = newMiniTextField(35, 15, Pos.CENTER_RIGHT);
		got.setPromptText("000");
		TextField outOf = newMiniTextField(35, 15, Pos.CENTER_RIGHT);
		outOf.setPromptText("000");

		got.setOnKeyTyped(e -> {
			String character = e.getCharacter();
			// Skip if (not a number OR has another . after the first .)
			if (character.equals("e")) {
				e.consume();
			}
			if (!character.matches("[0-9.]") || (character.equals(".") && got.getText().contains("."))) {
				e.consume();
			}
		});

		//numericFilter(got);
		numericFilter(outOf);

		Label gradePercent = new Label("--.--%");
		gradePercent.getStyleClass().add("tempText");
		gradePercent.setPrefWidth(40);
		gradePercent.setTextAlignment(TextAlignment.RIGHT);

		got.textProperty().addListener((obsVal, oldVal, newVal) -> {
			gradePercent.setText(updateGradePercent(got.getText(), outOf.getText()));
		});
		outOf.textProperty().addListener((obsVal, oldVal, newVal) -> {
			gradePercent.setText(updateGradePercent(got.getText(), outOf.getText()));
		});

		Button toggleEst = new Button(); // <--------------------------------------- NOT DONE YET!
		toggleEst.setPrefHeight(15);
		toggleEst.setMinHeight(15);
		toggleEst.setPrefWidth(15);

		AnchorPane newGradeComp = new AnchorPane();
		newGradeComp.setPrefSize(40, 30);
		newGradeComp.getChildren().addAll(got, outOf, gradePercent, toggleEst);

		got.setLayoutX(5);
		outOf.setLayoutX(5);
		outOf.setLayoutY(15);
		gradePercent.setLayoutY(30);

		return newGradeComp;
	}

	// ------------------------------------------------------------------------------- Load helper
	private String updateGradePercent(String gotIn, String outOfIn) {
		if (gotIn.equals("") || outOfIn.equals("")) {
			System.out.println("one is null");
			return "--.--%";
		} else if (Double.parseDouble(outOfIn) <= 0) {
			return "--.--%";
		} else {
			return String.format("%.2f%%",
						(Double.parseDouble(gotIn)/Double.parseDouble(outOfIn)) * 100);
		}
	}

	private void numericFilter(TextField textfieldIn) {
		textfieldIn.setOnKeyTyped(e -> {
			String character = e.getCharacter();
			// Skip if (not a number OR has another . after the first .)
			if (!character.matches("[0-9.]") || (character.equals(".") && textfieldIn.getText().contains("."))) {
				e.consume();
			}
		});
	}

	private void replaceAllNull(String[] rowDataIn, boolean[] isStringLst) {
		for (int i = 0; i < rowDataIn.length; i++) {
			rowDataIn[i] = replaceNull(rowDataIn[i], isStringLst[i]);
		}
	}

	private String replaceNull(String dataIn, boolean isString) {
		if (dataIn == null) {
			if (isString) {
				return "";
			} else {
				return "-1";
			}
		} else {
			return dataIn;
		}
	}

	private Node getCompLst(Obj objIn, Estat table) {
		switch (table) {
			case Class:
				SemObj parentSemObj = ((ClassObj)objIn).getParent();
				TitledPane parentSemComp = parentSemObj.getComponent();
				return parentSemComp.getContent();
			case Part:
				ClassObj parentClassObj = ((PartObj)objIn).getParent();
				TitledPane parentClassComp = parentClassObj.getComponent();
				return parentClassComp.getContent();
			case Grade:
				PartObj parentPartObj = ((GradeObj)objIn).getParent();
				HBox parentPartComp = parentPartObj.getComponent();
				return ((ScrollPane)parentPartComp.getChildren().get(1)).getContent();
			default:
				System.err.println("2nd arg error");
				return null;
		}
	}

	// ---------------------------------------------------------------- Component helper functions
	private HBox newClassStat() {
		// In threshold
		String thresholdPt1 = String.format("A > %8s %%\n", "");
		String thresholdPt2 = String.format("B > %8s %%\n", "");
		String thresholdPt3 = String.format("C > %8s %%\n", "");
		Label thresholdLabel = new Label(thresholdPt1 + thresholdPt2 + thresholdPt3);

		TextField thresholdA = newMiniTextField(38, 15, Pos.CENTER_RIGHT);
		TextField thresholdB = newMiniTextField(38, 15, Pos.CENTER_RIGHT);
		TextField thresholdC = newMiniTextField(38, 15, Pos.CENTER_RIGHT);

		VBox thresholdABC = new VBox();
		thresholdABC.setLayoutX(12);
		thresholdABC.getChildren().addAll(thresholdA, thresholdB, thresholdC);

		// In actualGrade
		Label actualGradeLabel = new Label("Est: A\nAct:");

		ChoiceBox<Character> actualGrade = new ChoiceBox<Character>();
		actualGrade.setPrefSize(25, 20);
		actualGrade.setMinSize(25, 20);
		actualGrade.setLayoutX(12);
		actualGrade.setLayoutY(12);
		actualGrade.getStyleClass().add("tempText");
		actualGrade.getItems().addAll('A', 'B', 'C', 'D', 'F', '-');
		actualGrade.getSelectionModel().selectedItemProperty().addListener(e -> {
            actualGrade.lookup(".arrow").setVisible(false);
        });

		// In classStat 
		String classStatPt1 = String.format("%9s Total\n", "");
		String classStatPt2 = String.format("Point: %3s 000.0%%\n", "");
		String classStatPt3 = "Percent: 000.0%";
		Label classCalc = new Label(classStatPt1 + classStatPt2 + classStatPt3);
		classCalc.setPrefSize(75, 45);
		classCalc.setMinSize(75, 45);
		//classCalc.setAlignment(Pos.TOP_RIGHT);

		AnchorPane thresholdSect = new AnchorPane();
		thresholdSect.setPrefHeight(35);
		thresholdSect.setPrefWidth(45);
		thresholdSect.getChildren().addAll(thresholdLabel, thresholdABC);

		AnchorPane actualGradeSect = new AnchorPane();
		actualGradeSect.setPrefHeight(35);
		actualGradeSect.setPrefWidth(45);
		actualGradeSect.getChildren().addAll(actualGradeLabel, actualGrade);

		TextArea classNote = new TextArea();
		classNote.setPromptText("Notes:");
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
		miniText.getStyleClass().add("tempText");
		return miniText;
	}

	private AnchorPane newPartStat() {
		TextField partName = newMiniTextField(95, 15, Pos.CENTER);
		partName.setPromptText("Part name");

		TextField partPercent = newMiniTextField(32, 15, Pos.CENTER_RIGHT);
		partPercent.setPromptText("00.0");

		String pt1 = String.format("%43s %%\n", "");
		String pt2 = String.format("Point: %3s 000.0%% | 000.0%%\n", "");
		String pt3 = "Percent: 000.0% | 000.0%";
		Label partCalc = new Label(pt1 + pt2 + pt3);

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
