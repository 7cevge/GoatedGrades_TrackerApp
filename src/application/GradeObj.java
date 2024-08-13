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
    private boolean isEst;
    private int gradeOrder; // not null
    private int partId; // not null

    private PartObj parent; // not null
    private boolean isDirty; // not null

    private AnchorPane component;

    private double percent;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public GradeObj(int gradeOrderin, PartObj parentIn, AnchorPane componentIn) {
        setComponent(componentIn);

        setGradeId(-1); // irrelavent
        setGradeGot(-1);
        setGradeOutOf(-1);
        setGradeGotEst(-1);
        setGradeOutOfEst(-1);
        setGradeNote(null);
        setGradeDate(-1,-1,-1);
        setIsEst(0);
        setGradeOrder(gradeOrderin);
        setPartId(-1); // irrelavent

        setParent(parentIn);
        parent.updateGradeLst(this, true);
        isDirty = true;
    }

    // Constructor for existing data
    public GradeObj(int gradeIdIn, double gradeGotIn, double gradeOutOfIn, double gradeGotEstIn, 
                double gradeOutOfEstIn, String gradeNoteIn, int gradeDDIn, int gradeMMIn, 
                int gradeYYIn, int isEstIn, int gradeOrderIn, int partIdIn, PartObj parentIn, 
                AnchorPane componentIn) {
        setComponent(componentIn);

        setGradeId(gradeIdIn);
        setGradeGot(gradeGotIn);
        setGradeOutOf(gradeOutOfIn);
        setGradeGotEst(gradeGotEstIn);
        setGradeOutOfEst(gradeOutOfEstIn);
        setGradeNote(gradeNoteIn);
        setGradeDate(gradeDDIn, gradeMMIn, gradeYYIn);
        setIsEst(isEstIn);
        setGradeOrder(gradeOrderIn);
        setPartId(partIdIn);

        setParent(parentIn);
        parent.updateGradeLst(this, true);
        isDirty = false;
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

    // IsEst
    private void setIsEst(int isEstIn) {
        if (isEstIn == 0) {
            isEst = false;
        } else if (isEstIn == 1) {
            isEst = true;
        } else {
            isEst = false;
            System.err.println("Invalid arg on setIsEst!");
        }
    }
    public void updateIsEst(int isEstIn) {
        setIsEst(isEstIn);
        isDirty = true;
    }
    public boolean getIsEst() {return isEst;}

    // GradeOrder
    private void setGradeOrder(int gradeOrderIn) {
        gradeOrder = gradeOrderIn;
    }
    public void updateGradeOrder(int gradeOrderIn) {
        setGradeOrder(gradeOrderIn);
        isDirty = true;
    }
    public int getGradeOrder() {return gradeOrder;}

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
