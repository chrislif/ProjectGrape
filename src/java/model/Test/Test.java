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

    public Test(int assessmentID, int assessmentLevel, String tag, List<Question> questionList, int teacherID) {
        super(assessmentID, assessmentLevel, tag, questionList);
        this.teacherID = teacherID;
    }
    
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
