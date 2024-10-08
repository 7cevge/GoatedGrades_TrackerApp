package application;

import java.util.ArrayList;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

public class ClassObj extends Obj {
    // From database
    private int classId; // not null
    private String className; // not null
    private String classCode;
    private double classCredit;
    private double classGradeA;
    private double classGradeB;
    private double classGradeC;
    private String classActualGrade;
    private String classNote;
    private int classOrder; // not null
    private int semId; // not null

    // Temporary
    private SemObj parent; // not null
    private ArrayList<PartObj> partLst = new ArrayList<PartObj>(8);
    private boolean isDirty; // not null

    private TitledPane component;

    private AnchorPane classBar = new AnchorPane();
    private double percentGrade;
    private double pointGrade;
    private char estGrade;


    // ------------------------------------------------------------------------------ Constructors
    // Default constructor for new data
    public ClassObj(int classOrderIn, SemObj parentIn, TitledPane componentIn) {
        setComponent(componentIn);

        setClassId(-1); // irrelavent
        setClassName("Class" + classOrderIn);
        setClassCode(null);
        setClassCredit(-1);
        setClassGrade(-1, 'a');
        setClassGrade(-1, 'b');
        setClassGrade(-1, 'c');
        setClassActualGrade(null);
        setClassNote(null);
        setClassOrder(classOrderIn);
        setSemId(-1); // irrelavent

        setParent(parentIn);
        parent.updateClassLst(this, true);
        isDirty = true;
    }

    // Constructor for existing data
    public ClassObj(int classIdIn, String classNameIn, String classCodeIn, double classCreditIn, 
                double classGradeAIn, double classGradeBIn, double classGradeCIn, 
                String classActualGradeIn, String classNoteIn, int classOrderIn, int semIdIn, 
                SemObj parentIn, TitledPane componentIn) {
        setComponent(componentIn);

        setClassId(classIdIn);
        setClassName(classNameIn);
        setClassCode(classCodeIn);
        setClassCredit(classCreditIn);
        setClassGrade(classGradeAIn, 'a');
        setClassGrade(classGradeBIn, 'b');
        setClassGrade(classGradeCIn, 'c');
        setClassActualGrade(classActualGradeIn);
        setClassNote(classNoteIn);
        setClassOrder(classOrderIn);
        setSemId(semIdIn);

        setParent(parentIn);
        parent.updateClassLst(this, true);
        isDirty = false;
    }

    // ------------------------------------------------------------ Set, get, and update functions
    // ClassId - no update
    private void setClassId(int classIdIn) {
        classId = classIdIn;
    }
    public int getClassId() {return classId;}

    // ClassName
    private void setClassName(String classNameIn) {
        className = classNameIn;

        component.setText(className);
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

        //component
    }
    public void updateClassNote(String classNoteIn) {
        setClassNote(classNoteIn);
        isDirty = true;
    }
    public String getClassNote() {return classNote;}

    // ClassOrder
    private void setClassOrder(int classOrderIn) {
        classOrder = classOrderIn;
    }
    public void updateClassOrder(int classOrderIn) {
        setClassOrder(classOrderIn);
        isDirty = true;
    }
    public int getClassOrder() {return classOrder;}

    // SemId - no update
    private void setSemId(int SemIdIn) {
        semId = SemIdIn;
    }
    public int getSemId() {return semId;}

    // Parent - no update
    private void setParent(SemObj parentIn) {
        parent = parentIn;
    }
    public SemObj getParent() {return parent;}

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

    // Component
    public void setComponent(TitledPane componentIn) {
        component = componentIn;
    }
    public TitledPane getComponent() {return component;}
}
