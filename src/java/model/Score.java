package model;

/**
 *
 * @author chris
 */
public class Score {
    private int scoreID;
    private int questionNumber;
    private String userAnswer;
    private Boolean isCorrect;

    public Score() {}

    public Score(int scoreID, int questionNumber, String userAnswer, Boolean isCorrect) {
        this.scoreID = scoreID;
        this.questionNumber = questionNumber;
        this.userAnswer = userAnswer;
        this.isCorrect = isCorrect;
    }

    public int getScoreID() {
        return scoreID;
    }

    public void setScoreID(int scoreID) {
        this.scoreID = scoreID;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
