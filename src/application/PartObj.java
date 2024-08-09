package application;

import java.util.ArrayList;

import javafx.scene.layout.HBox;

public class PartObj extends Obj {
    private int partId; // not null
    private String partName; // not null
    private double partPercent; // not null
    private String partNote;
    private int classId; // not null

    private ClassObj parent; // not null
    private ArrayList<GradeObj> gradeLst = new ArrayList<GradeObj>(8); // List of cachePartIds
    private boolean isDirty; // not null

    private HBox component;

    // ------------------------------------------------------------------------------- Constructors
    // Default constructor for new data
    public PartObj(ClassObj parentIn, HBox componentIn) {
        setPartId(-1); // irrelavent
        setPartName("PART");
        setPartPercent(-1);
        setPartNote(null);
        setClassId(-1); // irrelavent

        setParent(parentIn);
        isDirty = true;

        setComponent(componentIn);
    }

    // Constructor for existing data
    public PartObj(int partIdIn, String partNameIn, double partPercentIn, String partNoteIn, 
        int classIdIn, ClassObj parentIn, HBox componentIn) {
        setPartId(partIdIn); // irrelavent
        setPartName(partNameIn);
        setPartPercent(partPercentIn);
        setPartNote(partNoteIn);
        setClassId(classIdIn); // irrelavent

        setParent(parentIn);
        isDirty = false;

        setComponent(componentIn);
    }

    // ------------------------------------------------------------- Set, get, and update functions
    // PartId - no update
    private void setPartId(int partIdIn) {
        partId = partIdIn;
    }
    public int getPartId() {return partId;}

    // PartName
    private void setPartName(String partNameIn) {
        partName = partNameIn;
    }
    public void updatePartName(String partNameIn) {
        setPartName(partNameIn);
        isDirty = true;
    }
    public String getPartName() {return partName;}

    // PartPercent
    private void setPartPercent(double partPercentIn) {
        partPercent = partPercentIn;
    }
    public void updatePartName(double partPercentIn) {
        setPartPercent(partPercentIn);
        isDirty = true;
    }
    public double getPartPercent() {return partPercent;}

    // PartNote
    private void setPartNote(String partNoteIn) {
        partNote = partNoteIn;
    }
    public void updatePartNote(String partNoteIn) {
        setPartNote(partNoteIn);
        isDirty = true;
    }
    public String getPartNote() {return partNote;}

    // ClassId - no update
    private void setClassId(int classIdIn) {
        classId = classIdIn;
    }
    public int getClassId() {return classId;}

    // Parent - no update
    private void setParent(ClassObj parentIn) {
        parent = parentIn;
    }
    public ClassObj getParent() {return parent;}
    
    // GradeLst - no set
    public void updateGradeLst(GradeObj gradeIn, boolean add) {
        if (add) {
            gradeLst.add(gradeIn);
        } else {
            gradeLst.remove(gradeIn);
        }
    }
    public ArrayList<GradeObj> getGradeLst() {return gradeLst;}

    // IsDirty
    public boolean getIsDirty() {return isDirty;}

    // Component
    public void setComponent(HBox componentIn) {
        component = componentIn;
    }
    public HBox getComponent() {return component;}
}
