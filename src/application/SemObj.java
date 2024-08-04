package application;

import java.util.ArrayList;

public class SemObj {
    private static int semCount = 0;

    private int semId; // not null
    private String semName; // not null
    private String semNote;

    private int cacheSemId; // not null
    private ArrayList<ClassObj> classLst = new ArrayList<ClassObj>(8); // list of cacheClassIds
    private boolean isDirty; // not null

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public SemObj() {
        setSemId(-1); // irrelavent
        setSemName("SEM");
        setSemNote(null);

        setCacheSemId(semCount);
        semCount++;
        isDirty = true;
    }

    // Constructor for existing data
    public SemObj(int semIdIn, String semNameIn, String semNoteIn) {
        setSemId(semIdIn);
        setSemName(semNameIn);
        setSemNote(semNoteIn);

        setCacheSemId(semCount);
        semCount++;
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

    // CacheSemId - no update
    private void setCacheSemId(int cacheSemIdIn) {
        cacheSemId = cacheSemIdIn;
    }
    public int getCacheSemId() {return cacheSemId;}

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
