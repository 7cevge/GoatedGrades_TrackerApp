package application;

import java.util.ArrayList;

import javafx.scene.control.TitledPane;

public class SemObj extends Obj {
    private int semId; // not null
    private String semName; // not null
    private String semNote;
    private int semOrder; // not null

    private ArrayList<ClassObj> classLst = new ArrayList<ClassObj>(8);
    private boolean isDirty; // not null

    private TitledPane component;

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

        component.setText(semName);
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
}
