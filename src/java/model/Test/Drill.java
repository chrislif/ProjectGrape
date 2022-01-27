package model.Test;

import java.util.List;
import model.Assessment;
import model.Question;

/**
 *
 * @author chris
 */
public class Drill extends Assessment{
    public Drill(int assessmentID, int assessmentLevel, List<String> tagList, List<Question> questionList) {
        super(assessmentID, assessmentLevel, tagList, questionList);
    }
}
