package model.Test;

import java.util.List;
import model.Assessment;
import model.Question;

/**
 *
 * @author chris
 */
public class Test extends Assessment{
    private int teacherID;

    public Test(int assessmentID, int assessmentLevel, List<String> tagList, List<Question> questionList, int teacherID) {
        super(assessmentID, assessmentLevel, tagList, questionList);
        this.teacherID = teacherID;
    }
    
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
