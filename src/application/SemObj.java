package application;

import java.util.ArrayList;

import javafx.scene.control.TitledPane;

public class SemObj extends Obj {
    private int semId; // not null
    private String semName; // not null
    private String semNote;

    private ArrayList<ClassObj> classLst = new ArrayList<ClassObj>(8); // list of cacheClassIds
    private boolean isDirty; // not null

    private TitledPane component;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public SemObj(TitledPane componentIn) {
        setSemId(-1); // irrelavent
        setSemName("SEM");
        setSemNote(null);

        isDirty = true;

        setComponent(componentIn);
        Start.getCurrentUser().updateSemLst(this, true, false);
    }

    // Constructor for existing data
    public SemObj(int semIdIn, String semNameIn, String semNoteIn, TitledPane componentIn) {
        setSemId(semIdIn);
        setSemName(semNameIn);
        setSemNote(semNoteIn);

        isDirty = false;

        setComponent(componentIn);
        Start.getCurrentUser().updateSemLst(this, true, true);
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
        setSemName(semNoteIn);
        isDirty = true;
    }
    public String getSemNote() {return semNote;}

    // ClassLst - no set
    public void updateClassLst(ClassObj classIn, boolean add, boolean init) {
        if (add) {
            classLst.add(classIn);
        } else {
            classLst.remove(classIn);
        }

        if (!init) {
            isDirty = true;
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
