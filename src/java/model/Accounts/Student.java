package model.Accounts;

import model.Account;

/**
 *
 * @author chris
 */
public class Student extends Account{
    private int parentID;
    private int schoolID;

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }
}
