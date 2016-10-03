import java.util.ArrayList;

/**
 * Created by Anastasia on 03.10.2016.
 */
public class Question {
    private String questionText;
    private ArrayList<Answer> answers;

    public Question (String questionText, ArrayList<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }
}
