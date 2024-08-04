package application;

import java.util.ArrayList;

public class ClassObj {
    private static int classCount = 0;

    private int classId; // not null
    private String className; // not null
    private String classCode;
    private double classCredit;
    private double classGradeA;
    private double classGradeB;
    private double classGradeC;
    private String classActualGrade;
    private String classNote;
    private int semId; // not null

    private int cacheClassId; // not null
    private int cacheSemId; // not null
    private ArrayList<PartObj> partLst = new ArrayList<PartObj>(8); // List of cachePartIds
    private boolean isDirty; // not null

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public ClassObj(int cacheSemIdIn) {
        setClassId(-1); // irrelavent
        setClassName("CLASS");
        setClassCode(null);
        setClassCredit(-1);
        setClassGrade(-1, 'a');
        setClassGrade(-1, 'b');
        setClassGrade(-1, 'c');
        setClassActualGrade(null);
        setClassNote(null);
        setSemId(-1); // irrelavent

        setCacheClassId(classCount);
        setCacheSemId(cacheSemIdIn);
        classCount++;
        isDirty = true;
    }

    // Constructor for existing data
    public ClassObj(int classIdIn, String classNameIn, String classCodeIn, int classCreditIn, 
        int classGradeAIn, int classGradeBIn, int classGradeCIn, String classActualGradeIn, 
        String classNoteIn, int semIdIn, int cacheSemIdIn) {
        setClassId(classIdIn);
        setClassName(classNameIn);
        setClassCode(classCodeIn);
        setClassCredit(classCreditIn);
        setClassGrade(classGradeAIn, 'a');
        setClassGrade(classGradeBIn, 'b');
        setClassGrade(classGradeCIn, 'c');
        setClassActualGrade(classActualGradeIn);
        setClassNote(classNoteIn);
        setSemId(semIdIn);

        setCacheClassId(classCount);
        setCacheSemId(cacheSemIdIn);
        classCount++;
        isDirty = false;
    }

    // ------------------------------------------------------------- Set, get, and update functions
    // ClassId - no update
    private void setClassId(int classIdIn) {
        classId = classIdIn;
    }
    public int getClassId() {return classId;}

    // ClassName
    private void setClassName(String classNameIn) {
        className = classNameIn;
    }
    public void updateClassName(String classNameIn) {
        setClassName(classNameIn);
        isDirty = true;
    }
    public String getClassName() {return className;}

    // ClassCode
    private void setClassCode(String classCodeIn) {
        classCode = classCodeIn;
    }
    public void updateClassCode(String classCodeIn) {
        updateClassCode(classCodeIn);
        isDirty = true;
    }
    public String getClassCode() {return classCode;}

    // ClassCredit
    private void setClassCredit(double classCreditIn) {
        classCredit = classCreditIn;
    }
    public void updateClassCredit(double classCreditIn) {
        setClassCredit(classCreditIn);
        isDirty = true;
    }
    public double getClassCredit() {return classCredit;}

    // ClassGradeLetter
    private void setClassGrade(double classGradeIn, char letter) {
        switch (letter) {
            case 'a':
                classGradeA = classGradeIn;
                break;
        
            case 'b':
                classGradeB = classGradeIn;
                break;

            case 'c':
                classGradeC = classGradeIn;
                break;

            default:
                System.err.println("invalid letter");
                break;
        }
    }
    public void updateClassGrade(double classGradeIn, char letter) {
        setClassGrade(classGradeIn, letter);
        isDirty = true;
    }
    public double getClassGrade(char letter) {
        switch (letter) {
            case 'a':
                return classGradeA;
        
            case 'b':
                return classGradeB;

            case 'c':
                return classGradeC;

            default:
                System.err.println("invalid letter");
                return -1;
        }
    }

    // ClassActualGrade
    private void setClassActualGrade(String classActualGradeIn) {
        classActualGrade = classActualGradeIn;
    }
    public void updateClassActualGrade(String classActualGradeIn) {
        setClassActualGrade(classActualGradeIn);
        isDirty = true;
    }
    public String getClassActualGrade() {return classActualGrade;}

    // ClassNote
    private void setClassNote(String classNoteIn) {
        classNote = classNoteIn;
    }
    public void updateClassNote(String classNoteIn) {
        setClassNote(classNoteIn);
        isDirty = true;
    }
    public String getClassNote() {return classNote;}

    // SemId - no update
    private void setSemId(int SemIdIn) {
        semId = SemIdIn;
    }
    public int getSemId() {return semId;}

    // CacheClassId - no update
    private void setCacheClassId(int cacheClassIdIn) {
        cacheClassId = cacheClassIdIn;
    }
    public int getCacheClassId() {return cacheClassId;}

    // CacheSemId - no update
    private void setCacheSemId(int cacheSemIdIn) {
        cacheSemId = cacheSemIdIn;
    }
    public int getCacheSemId() {return cacheSemId;}

    // PartLst - no set
    public void updatePartLst(PartObj partIn, boolean add) {
        if (add) {
            partLst.add(partIn);
        } else {
            partLst.remove(partIn);
        }
    }
    public ArrayList<PartObj> getPartLst() {return partLst;}

    // IsDirty
    public boolean getIsDirty() {return isDirty;}
}
