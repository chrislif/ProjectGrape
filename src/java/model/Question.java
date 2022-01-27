package model;

/**
 *
 * @author chris
 */
public class Question {
    private int questionID;
    private int questionLevel;
    private String questionText;
    private String questionAnswer;
    private String tag;

    public Question() {}
    
    public Question(int questionID, int questionLevel, String questionText, String questionAnswer, String tag) {
        this.questionID = questionID;
        this.questionLevel = questionLevel;
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
        this.tag = tag;
    }
    
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(int questionLevel) {
        this.questionLevel = questionLevel;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public Boolean checkAnswer(String answer) {
        return false;
    }
}
