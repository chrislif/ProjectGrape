package controller.temporaryModels;

/**
 *
 * @author chris
 */
public class TempScore {
    private String userAnswer;
    private String correctAnswer;
    private Boolean isCorrect;

    public TempScore() {}
    
    public TempScore(String userAnswer, String correctAnswer, Boolean isCorrect) {
        this.userAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.isCorrect = isCorrect;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    
}
