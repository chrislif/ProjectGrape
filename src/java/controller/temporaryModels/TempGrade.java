/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.temporaryModels;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class TempGrade {
    private int quizID;
    public ArrayList<TempScore> scoreList;

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }
}
