/**
 * Created by Anastasia on 03.10.2016.
 */
public class Answer {
    private String answerText;
    private boolean isCorrect;

    public Answer(String answerText, boolean isCorrect ){
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public String getAnswerText(){
        return answerText;
    }

    public boolean getIsCorrect(){
        return isCorrect;
    }

    public void setAnswerText(String answerText){
        this.answerText = answerText;
    }

    public void setIsCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }

}
