
import java.lang.String;
import java.util.HashMap;

/**
 * In this Class will be created hashMap with Questions and Answers Pairs
 */
public class TestData {
    //Construktor makes a new HashMap with Pairs of Question(String)-Answers(Answer)
    public TestData(){
        HashMap <String, Answer> testDateHashMap = new HashMap<String, Answer>();

        //test for first Question
         testDateHashMap.put("Who is the next President of RF", new Answer("Putin", true));


    }

    //Private Class for Answers
    private class Answer{
        private Answer(String answerText,boolean isCorrect ){
            this.answerText=answerText;
            this.isCorrect=isCorrect;
        }
    }
}
