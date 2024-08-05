package application;

import javafx.scene.layout.AnchorPane;

public class GradeObj extends Obj {
    private int gradeId; // not null
    private double gradeGot;
    private double gradeOutOf;
    private double gradeGotEst;
    private double gradeOutOfEst;
    private String gradeNote;
    private int gradeDD;
    private int gradeMM;
    private int gradeYY;
    private int partId; // not null

    private PartObj parent; // not null
    private boolean isDirty; // not null

    private AnchorPane component;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public GradeObj(PartObj parentIn, AnchorPane componentIn) {
        setGradeId(-1); // irrelavent
        setGradeGot(-1);
        setGradeOutOf(-1);
        setGradeGotEst(-1);
        setGradeOutOfEst(-1);
        setGradeNote(null);
        setGradeDate(-1,-1,-1);
        setPartId(-1); // irrelavent

        setParent(parentIn);
        isDirty = true;

        setComponent(componentIn);
    }

    // Constructor for existing data
    public GradeObj(int gradeIdIn, double gradeGotIn, double gradeOutOfIn, double gradeGotEstIn, double gradeOutOfEstIn,
        String gradeNoteIn, int gradeDDIn, int gradeMMIn, int gradeYYIn, int partIdIn, PartObj parentIn, AnchorPane componentIn) {
        setGradeId(gradeIdIn); // irrelavent
        setGradeGot(gradeGotIn);
        setGradeOutOf(gradeOutOfIn);
        setGradeGotEst(gradeGotEstIn);
        setGradeOutOfEst(gradeOutOfEstIn);
        setGradeNote(gradeNoteIn);
        setGradeDate(gradeDDIn, gradeMMIn, gradeYYIn);
        setPartId(partIdIn); // irrelavent

        setParent(parentIn);
        isDirty = false;

        setComponent(componentIn);
    }

    // ------------------------------------------------------------- Set, get, and update functions
    // GradeId - no update
    private void setGradeId(int gradeIdIn) {
        gradeId = gradeIdIn;
    }
    public int getGradeId() {return gradeId;}

    // GradeGot
    private void setGradeGot(double gradeGotIn) {
        gradeGot = gradeGotIn;
    }
    public void updateGradeGot(double gradeGotIn) {
        setGradeGot(gradeGotIn);
        isDirty = true;
    }
    public double getGradeGot() {return gradeGot;}

    // GradeOutOf
    private void setGradeOutOf(double gradeOutOfIn) {
        gradeOutOf = gradeOutOfIn;
    }
    public void updateGradeOutOf(double gradeOutOfIn) {
        setGradeOutOf(gradeOutOfIn);
        isDirty = true;
    }
    public double getGradeOutOf() {return gradeOutOf;}

    // GradeGotEst
    private void setGradeGotEst(double gradeGotEstIn) {
        gradeGotEst = gradeGotEstIn;
    }
    public void updateGradeGotEst(double gradeGotEstIn) {
        setGradeGotEst(gradeGotEstIn);
        isDirty = true;
    }
    public double getGradeGotEst() {return gradeGotEst;}

    // GradeOutOfEst
    private void setGradeOutOfEst(double gradeOutOfEstIn) {
        gradeOutOfEst = gradeOutOfEstIn;
    }
    public void updateGradeOutOfEst(double gradeOutOfEstIn) {
        setGradeOutOfEst(gradeOutOfEstIn);
        isDirty = true;
    }
    public double getGradeOutOfEst() {return gradeOutOfEst;}

    // GradeNote
    private void setGradeNote(String gradeNoteIn) {
        gradeNote = gradeNoteIn;
    }
    public void updateGradeNote(String gradeNoteIn) {
        setGradeNote(gradeNoteIn);
        isDirty = true;
    }
    public String getGradeNote() {return gradeNote;}

    // GradeDate
    private void setGradeDate(int gradeDDIn, int gradeMMIn, int gradeYYIn) {
        gradeDD = gradeDDIn;
        gradeMM = gradeMMIn;
        gradeYY = gradeYYIn;
    }
    public void updatePartName(int gradeDDIn, int gradeMMIn, int gradeYYIn) {
        setGradeDate(gradeDDIn, gradeMMIn, gradeYYIn);
        isDirty = true;
    }
    public int[] getGradeDate() {
        int[] gradeDate = {gradeDD, gradeMM, gradeYY};
        return gradeDate;
    }

    // PartId - no update
    private void setPartId(int partIdIn) {
        partId = partIdIn;
    }
    public int getPartId() {return partId;}

    // Parent - no update
    private void setParent(PartObj parentIn) {
        parent = parentIn;
    }
    public PartObj getParent() {return parent;}

    // IsDirty
    public boolean getIsDirty() {return isDirty;}

    // Component
    public void setComponent(AnchorPane componentIn) {
        component = componentIn;
    }
    public AnchorPane getComponent() {return component;}
}
