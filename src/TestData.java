import java.lang.String;
import java.util.ArrayList;

/**
 * The class containing data for a particular test
 */

public class TestData {
    //I think we will need TestID later for Databese and when it will be more than one Test
    private int testId;
    private String testName;
    private String testDescription;
    private ArrayList<Question> questions;

    //Construktor. Create new TestData, fill the Question and Answers (using read from the file)
    public TestData(int fileIndex){
        FileManipulator fileManipulator = FileManipulator.getInstance();
        ArrayList<String> testData = fileManipulator.readFileToStringList("./tests/test" + fileIndex + ".txt");

        this.testName = testData.remove(0);
        this.testDescription = testData.remove(0);
        this.questions = new ArrayList<>();

        for (String questionString : testData) {
            String[] parsedQuestionData = questionString.split("\\|\\|\\|");
            ArrayList<Question.Answer> answers = new ArrayList<>();
            boolean isCorrect = true;
            for (int i = 1; i < parsedQuestionData.length; i++) {
                if (parsedQuestionData[i].equals("divider25745406472")) {
                    isCorrect = false;
                    continue;
                }
                answers.add(new Question.Answer(parsedQuestionData[i],isCorrect));
            }
            questions.add(new Question(parsedQuestionData[0],answers));
        }
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }


    //Class Question for creating and keeping Questions
    protected class Question {
        private String questionText;
        private ArrayList<Answer> answers;
        //Construktor
        public Question (String questionText, ArrayList<Answer> answers) {
            this.questionText = questionText;
            this.answers = answers;
        }

        public String getQuestionText() {
            return questionText;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public ArrayList<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(ArrayList<Answer> answers) {
            this.answers = answers;
        }

        //Class Answer for creating and keeping Answers
        protected class Answer {
            private String answerText;
            private boolean isCorrect;
            //Construktor
            public Answer(String answerText, boolean isCorrect ){
                this.answerText = answerText;
                this.isCorrect = isCorrect;
            }

            public String getAnswerText() {
                return answerText;
            }

            public void setAnswerText(String answerText) {
                this.answerText = answerText;
            }

            public boolean isCorrect() {
                return isCorrect;
            }

            public void setCorrect(boolean isCorrect) {
                this.isCorrect = isCorrect;
            }
        }
    }
}
