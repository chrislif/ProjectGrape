/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Anthony
 */
public class AssessmentQuestions {
    private int assessmentID;
    private int questionID;

    public AssessmentQuestions(int assessmentID, int questionID) {
        this.assessmentID = assessmentID;
        this.questionID = questionID;
    }
    
    public AssessmentQuestions() {
        
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    
}
