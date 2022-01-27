package model.Test;

import java.util.List;
import model.Assessment;
import model.Question;

/**
 *
 * @author chris
 */
public class Quiz extends Assessment{
    private Boolean isRandomized;

    public Quiz(int assessmentID, int assessmentLevel, List<String> tagList, List<Question> questionList, Boolean isRandomized) {
        super(assessmentID, assessmentLevel, tagList, questionList);
        this.isRandomized = isRandomized;
    }
    
    public Boolean getIsRandomized() {
        return isRandomized;
    }

    public void setIsRandomized(Boolean isRandomized) {
        this.isRandomized = isRandomized;
    }
}
