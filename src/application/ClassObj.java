package application;

import java.util.ArrayList;

public class ClassObj {
    private static int ClassCount = 0;

    private int classId;
    private String className;
    private String classCode;
    private int classCredit;
    private int classGradeA;
    private int classGradeB;
    private int classGradeC;
    private String classActualGrade;
    private String classNote;
    private int semId;

    private int cacheClassId;
    private int cacheSemId;
    private ArrayList<PartObj> partLst = new ArrayList<PartObj>(8); // List of cachePartIds
    private boolean isDirty;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public ClassObj() {
        setClassId(0); // irrelavent
        setClassName("CLASS");
        ClassCount++;
        isDirty = true;
    }

    // Constructor for existing data
    public ClassObj(int semIdIn, String semNameIn, String semNoteIn) {
        
        ClassCount++;
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
    private void setClassCredit(int classCreditIn) {
        classCredit = classCreditIn;
    }
    public void updateClassCredit(int classCreditIn) {
        setClassCredit(classCreditIn);
        isDirty = true;
    }
    public int getClassCredit() {return classCredit;}

    // ClassGradeLetter
    private void setClassGrade(int classGradeIn, char letter) {
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
    public void updateClassGrade(int classGradeIn, char letter) {
        setClassGrade(classGradeIn, letter);
        isDirty = true;
    }
    public int getClassGrade(char letter) {
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
    // ClassNote
    // SemId
    // CacheClassId
    // CacheSemId

    // PartLst
    public void modPartLst(PartObj partIn, boolean add) {
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
