package application;

import java.util.ArrayList;

public class SemObj {
    private static int SemCount = 0;

    private int semId;
    private String semName;
    private String semNote;

    private int casheId;
    private ArrayList<ClassObj> myClassLst = new ArrayList<ClassObj>(8);
    private boolean isDirty;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public SemObj() {
        
    }

    // Constructor for existing data
    public SemObj(int semIdIn, String semNameIn, String semNoteIn) {
        isDirty = false;
    }

    // ------------------------------------------------------------- Set, get, and update functions
    private void setSemId(int semIdIn) {
        // Only call by constructor
        semId = semIdIn;
    }
    public int getSemId() {return semId;}

    public void setSemName(String semNameIn) {
        semName = semNameIn;
        //setIsDirty(true);
    }
    public String getSemName() {return semName;}

    public void setSemNote(String semNoteIn) {
        semNote = semNoteIn;
        isDirty = true;
    }
    public String getSemNote() {return semNote;}

    private void setCasheId(int casheIdIn) {
        // Only call by constructor
        casheId = casheIdIn;
    }
    public int getCasheId() {return casheId;}

    public boolean getIsDirty() {return isDirty;}

}
