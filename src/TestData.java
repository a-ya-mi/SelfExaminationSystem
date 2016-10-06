
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class TestData {
    //int testId; нужен ли он?
    private String testName;
    private String testDescription;
    private ArrayList<Question> questions;

    //Construktor makes a new HashMap with Pairs of Question(String)-Answers(Answer)
    public TestData(int fileIndex){
/**
 * fileIndex - номер файла, откуда берем тест. Если тестов будет несколько, то файлы, допустим будут называться
 * test1.txt, test2.txt
 */
        this.testName = "We get test name from some file";
        this.testDescription = "We get test description from some file";
        this.questions = new ArrayList<Question>();

        // now we get all questions for the test from some file
        //test for first Question
        ArrayList<Answer> listOfAnswersForTheQuestion = new ArrayList<Answer>( // we put all answers for the question into ArrayList
                Arrays.asList(
                        new Answer("Putin", true),
                        new Answer("Navalniy", false),
                        new Answer("Obama", false)
                        ));
        questions.add(new Question("Who is the next President of RF", listOfAnswersForTheQuestion)); // we put the question into ArrayList of questions
    }


    //private Class for keeping Question
    private class Question {
        private String questionText;
        private ArrayList<Answer> answers;

        public Question (String questionText, ArrayList<Answer> answers) {
            this.questionText = questionText;
            this.answers = answers;
        }

        public String questionText(){
            return questionText;
        }

        public ArrayList<Answer> getArrayListAnswers(){
            return answers;
        }

        public void setquestionText(String questionText){
            this.questionText = questionText;
        }

        public void setArrayListAnswers(ArrayList<Answer> answers){
            this.answers = answers;
        }
    }

    //private Class for keeping Answer
    private class Answer {
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
}
