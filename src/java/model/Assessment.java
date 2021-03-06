package model;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public abstract class Assessment {
    private int assessmentID;
    private int assessmentLevel;
    private String tag;
    public ArrayList<Question> questionList;

    public Assessment() {}
    
    public Assessment(int assessmentID, int assessmentLevel, String tag, ArrayList<Question> questionList) {
        this.assessmentID = assessmentID;
        this.assessmentLevel = assessmentLevel;
        this.tag = tag;
        this.questionList = questionList;
    }
    
    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public int getAssessmentLevel() {
        return assessmentLevel;
    }

    public void setAssessmentLevel(int assessmentLevel) {
        this.assessmentLevel = assessmentLevel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
