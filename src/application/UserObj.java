package application;

public class UserObj {
    private int userId;
    private String username;
    private String userpw;
    private String userNote;
    private String userPfp;

    private boolean isDirty;

    // -------------------------------------------------------------------------------- Constructor
    public UserObj() {
        setUserId(0);
        setUsername(null);
        setUserpw(null);
        setUserNote(null);
        setUserPfp(null);
        isDirty = false;
    }

    public UserObj(int userIdIn, String usernameIn, String userpwIn, String userNoteIn, String userPfpIn) {
        setUserId(userIdIn);
        setUsername(usernameIn);
        setUserpw(userpwIn);
        setUserNote(userNoteIn);
        setUserPfp(userPfpIn);
        isDirty = false;
    }

    // ------------------------------------------------------------- Set, get, and update functions
    // Userid
    private void setUserId(int userIdIn) {
        userId = userIdIn;
    }
    public int getUserId() {return userId;}

    // Username
    private void setUsername(String usernameIn) {
        username = usernameIn;
    }
    public void updateUsername(String usernameIn) {
        username = usernameIn;
        isDirty = true;
    }
    public String getUsername() {return username;}

    // Userpw
    private void setUserpw(String userpwIn) {
        userpw = userpwIn;
    }
    public void updateUserpw(String userpwIn) {
        userpw = userpwIn;
        isDirty = true;
    }
    public String getUserpw() {return userpw;}

    // UserNote
    private void setUserNote(String userNoteIn) {
        userNote = userNoteIn;
    }
    public String getUserNote() {return userNote;}

    // UserPfp
    private void setUserPfp(String userPfpIn) {
        userPfp = userPfpIn;
    }
    public void updateUserPfp(String userPfpIn) {
        userPfp = userPfpIn;
        isDirty = true;
    }
    public String getUserPfp() {return userPfp;}

    // isDirty
    public boolean getIsDirty() {return isDirty;}
}
