package model.Test;

import java.util.ArrayList;
import model.Assessment;
import model.Question;

/**
 *
 * @author chris
 */
public class Drill extends Assessment{
    public Drill(int assessmentID, int assessmentLevel, String tag, ArrayList<Question> questionList) {
        super(assessmentID, assessmentLevel, tag, questionList);
    }
}
