package application;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

public class SemObj extends Obj {
    // From database
    private int semId; // not null
    private String semName; // not null
    private String semNote;
    private int semOrder; // not null

    // Temporary
    private ArrayList<ClassObj> classLst = new ArrayList<ClassObj>(8);
    private boolean isDirty; // not null

    private TitledPane component;
    
    private AnchorPane semBar = new AnchorPane();
    private int classCount = 0;
    private int creditCount = 0;
    private double semGPA = 0;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public SemObj(int semOrderIn, TitledPane componentIn) {
        setComponent(componentIn);

        setSemId(-1); // irrelavent
        setSemName("Sem" + semOrderIn);
        setSemNote(null);
        setSemOrder(semOrderIn);

        Start.getCurrentUser().updateSemLst(this, true);
        isDirty = true;
    }

    // Constructor for existing data
    public SemObj(int semIdIn, String semNameIn, String semNoteIn, int semOrderIn, 
                    TitledPane componentIn) {
        setComponent(componentIn);

        setSemId(semIdIn);
        setSemName(semNameIn);
        setSemNote(semNoteIn);
        setSemOrder(semOrderIn);

        Start.getCurrentUser().updateSemLst(this, true);
        isDirty = false;
    }

    // ------------------------------------------------------------- Set, get, and update functions
    // SemId - no update
    private void setSemId(int semIdIn) {
        semId = semIdIn;
    }
    public int getSemId() {return semId;}

    // SemName
    private void setSemName(String semNameIn) {
        semName = semNameIn;
        setSemBar();
    }
    public void updateSemName(String semNameIn) {
        setSemName(semNameIn);
        isDirty = true;
    }
    public String getSemName() {return semName;}

    // SemNote
    private void setSemNote(String semNoteIn) {
        semNote = semNoteIn;
    }
    public void updateSemNote(String semNoteIn) {
        setSemNote(semNoteIn);
        isDirty = true;
    }
    public String getSemNote() {return semNote;}

    // SemOrder
    private void setSemOrder(int semOrderIn) {
        semOrder = semOrderIn;
    }
    public void updateSemOrder(int semOrderIn) {
        setSemOrder(semOrderIn);
        isDirty = true;
    }
    public int getSemOrder() {return semOrder;}

    // ClassLst - no set
    public void updateClassLst(ClassObj classIn, boolean add) {
        if (add) {
            classLst.add(classIn);
        } else {
            classLst.remove(classIn);
        }
    }
    public ArrayList<ClassObj> getClassLst() {return classLst;}

    // IsDirty
    public boolean getIsDirty() {return isDirty;}

    // Component
    public void setComponent(TitledPane componentIn) {
        component = componentIn;
    }
    public TitledPane getComponent() {return component;}

    // ---------------------------------------------------------------------------- Calc components
    private void setSemBar() {
        String pt1 = String.format("%s", semName);
        String pt2 = String.format("%5s %d classes", "", classCount);
        String pt3 = String.format("%5s %d credits", "", creditCount);
        String pt4 = String.format("%5s GPA: %.2f", "", semGPA);

        Label barName = new Label(pt1);
        barName.getStyleClass().add("tempText");
        Label barCalc = new Label(pt2 + pt3 + pt4);
        barCalc.setAlignment(Pos.CENTER_RIGHT);
        barCalc.getStyleClass().add("tempText");

        AnchorPane.setRightAnchor(barCalc, 0.0);
        
        semBar.getChildren().addAll(barName, barCalc);
        semBar.setPrefSize(60, 15);
        semBar.prefWidthProperty().bind(component.widthProperty().subtract(36));

        component.setGraphic(semBar);
    }
}
