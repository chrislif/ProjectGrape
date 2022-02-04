package model.Test;

import java.util.List;
import model.Assessment;
import model.Question;

/**
 *
 * @author chris
 */
public class Quiz extends Assessment{
    public Quiz(int assessmentID, int assessmentLevel, String tag, List<Question> questionList) {
        super(assessmentID, assessmentLevel, tag, questionList);
    }
}
