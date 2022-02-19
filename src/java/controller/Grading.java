package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
    public static Boolean storeGrade(String scoreListJSON, Account currentUser) {
        Grade newGrade = createGrade(scoreListJSON, currentUser);
        
        try {
            GrapeDB.addGrade(newGrade);
            
            return true;
        }
        catch (SQLException ex) {
            return false;
        }
    }
    
    public static Grade createGrade(String scoreListJSON, Account currentUser) {
        Gson gson = new Gson();
        
        Type listType = new TypeToken<ArrayList<TempScore>>() {}.getType();
        ArrayList<TempScore> tempScoreList = gson.fromJson(scoreListJSON, listType);
        
        ArrayList<Score> scoreList = new ArrayList<>();
        int i = 1;
        for (TempScore ts : tempScoreList) {
            scoreList.add(new Score(0, i, ts.getUserAnswer(), ts.getIsCorrect()));
            i++;
        }
        
        Grade newGrade = new Grade();
        newGrade.scoreList = scoreList;
        newGrade.setAccountID(currentUser.getAccountID());
        
        return newGrade;
    }
}
