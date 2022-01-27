package model;

/**
 *
 * @author chris
 */
public class Score {
    private int accountID;
    private int assessmentID;
    private double gradePercent;

    public Score() {}
    
    public Score(int accountID, int assessmentID, double gradePercent) {
        this.accountID = accountID;
        this.assessmentID = assessmentID;
        this.gradePercent = gradePercent;
    }
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public double getGradePercent() {
        return gradePercent;
    }

    public void setGradePercent(double gradePercent) {
        this.gradePercent = gradePercent;
    }
}
