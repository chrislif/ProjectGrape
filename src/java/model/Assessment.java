/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
