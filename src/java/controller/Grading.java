/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.lang.reflect.Type;
import model.Grade;
import model.Score;

/**
 *
 * @author chris
 */
public class Grading {
    public static Grade createGrade(String scoreListJSON) {
        Gson gson = new Gson();
        
        Type listType = new TypeToken<ArrayList<TempScore>>() {}.getType();
        ArrayList<TempScore> tempScoreList = gson.fromJson(scoreListJSON, listType);
        
        
        Grade newGrade = new Grade();
        
        
        
        
        return newGrade;
    }
}
