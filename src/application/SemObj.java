package application;

import java.util.ArrayList;

public class SemObj {
    private static int SemCount = 0;

    private int semId;
    private String semName;
    private String semNote;

    private int cacheSemId;
    private ArrayList<ClassObj> classLst = new ArrayList<ClassObj>(8); // list of cacheClassIds
    private boolean isDirty;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public SemObj() {
        setSemId(0); // irrelavent
        setSemName("SEM");
        setSemNote(null);
        setCasheSemId(SemCount);
        SemCount++;
        isDirty = true;
    }

    // Constructor for existing data
    public SemObj(int semIdIn, String semNameIn, String semNoteIn) {
        setSemId(semIdIn);
        setSemName(semNameIn);
        setSemNote(semNoteIn);
        setCasheSemId(SemCount);
        SemCount++;
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

    // CasheSemId - no update
    private void setCasheSemId(int casheSemIdIn) {
        cacheSemId = casheSemIdIn;
    }
    public int getCasheSemId() {return cacheSemId;}

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
}
