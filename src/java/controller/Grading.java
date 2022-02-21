package controller;

import controller.temporaryModels.TempScore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.temporaryModels.TempGrade;
import data.GrapeDB;
import java.util.ArrayList;
import java.lang.reflect.Type;
import java.sql.SQLException;
import model.Account;
import model.Grade;
import model.Score;

/**
 *
 * @author chris
 */
public class Grading {

    protected static Boolean storeGrade(String gradeJSON, Account currentUser) {
        Grade newGrade = createGrade(gradeJSON, currentUser);

        try {
            GrapeDB.addGrade(newGrade);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    protected static Grade createGrade(String gradeJSON, Account currentUser) {
        Gson gson = new Gson();

        Type gradeType = new TypeToken<TempGrade>() {
        }.getType();
        TempGrade tempGrade = gson.fromJson(gradeJSON, gradeType);

        ArrayList<Score> scoreList = new ArrayList<>();
        int i = 1;
        for (TempScore ts : tempGrade.scoreList) {
            scoreList.add(new Score(0, i, ts.getUserAnswer(), ts.getIsCorrect()));
            i++;
        }

        Grade newGrade = new Grade(currentUser.getAccountID(), tempGrade.getQuizID());
        newGrade.scoreList = scoreList;

        return newGrade;
    }

    protected static ArrayList<Grade> retrieveGrades(int accountID) {
        try {
            ArrayList<Grade> gradeList = new ArrayList<>();
            gradeList = GrapeDB.getScores(accountID);
            
            return gradeList;
        } catch (SQLException ex) {

            return null;
        }
    }
}
