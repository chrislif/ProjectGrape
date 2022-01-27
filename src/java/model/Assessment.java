package model;

import java.util.List;

/**
 *
 * @author chris
 */
public abstract class Assessment {
    private int assessmentID;
    private int assessmentLevel;
    public List<String> tagList;
    public List<Question> questionList;

    public Assessment(int assessmentID, int assessmentLevel, List<String> tagList, List<Question> questionList) {
        this.assessmentID = assessmentID;
        this.assessmentLevel = assessmentLevel;
        this.tagList = tagList;
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
}
