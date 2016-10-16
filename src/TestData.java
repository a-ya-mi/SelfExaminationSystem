import java.lang.String;
import java.util.ArrayList;


/**
 * The class containing data for a particular test
 */

public class TestData {

    //I think we will need TestID later for Database and when it will be more than one Test
    private int testId;
    private String testName;
    private String testDescription;
    private ArrayList<Question> questions;

    //Constructor. Creates new TestData, fills the according Questions and Answers (reading it from the file)
    public TestData(int fileIndex){

        /**
         * We use fileManipulator to read all data about a test from a test file
         */
        FileManipulator fileManipulator = FileManipulator.getInstance();
        // you need to put here your path to "tests" directory!!!
        ArrayList<String> testData = fileManipulator.readFileToStringList("E:\\SelfExaminationSystemGIT\\SelfExaminationSystem\\tests\\test" + fileIndex + ".txt");

        this.testName = testData.remove(0); // 1st element of testData ArrayList is always testName (according to our file structure). We read it into this.testName and delete from testData ArrayList at the same time
        this.testDescription = testData.remove(0); // 2nd element of testData ArrayList is always testDescription, but since we already deleted 1st element, now testDescription became th1 1st element. We read it into this.testDescription and delete from testData ArrayList at the same time
        this.questions = new ArrayList<>(); // the rest of the elements of testData ArrayList are now questions since we deleted testName and testDescription

        for (String questionString : testData) { // we iterate through testData ArrayList - i.e. through each question String
            String[] parsedQuestionData = questionString.split("\\|\\|\\|"); // we parse question String into an array by "|||" (according to our file structure)
            ArrayList<Question.Answer> answers = new ArrayList<>(); // we create empty ArrayList for answers
            Question currentQuestion = new Question(parsedQuestionData[0],answers); // we create a new Question using Constructor and put parsedQuestionData[0] as questionText (because 1st element in a question string is always questionText according to our file structure) and put an EMPTY ArrayList for answers
            // now we need to fill the empty ArrayList for answers
            boolean isCorrect = true; // set isCorrect to true because (according to our file structure) first go the correct answers and then after "divider25745406472" - wrong answers
            for (int i = 1; i < parsedQuestionData.length; i++) { // we iterate through parsedQuestionData from 1 because parsedQuestionData[0] is questionText and the rest are answers
                if (parsedQuestionData[i].equals("divider25745406472")) { // when we meet the divider we turn isCorrect to false and go to next iteration "continue"
                    isCorrect = false;
                    continue;
                }
                answers.add(currentQuestion.new Answer(parsedQuestionData[i],isCorrect)); // we add to answers ArrayList of a current question a new answer via Constructor
            }
            questions.add(currentQuestion); // in the last step we add this current question to ArrayList of questions in TestData
        }
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTheNumberOfQuestions(){
        return questions.size();
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
        //Constructor
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

        /**
         * The method returns numberOfCorrectAnswers for a question
         */
        public int numberOfCorrectAnswers() {
            int numberOfCorrectAnswers = 0;
            for (Answer answer : answers) {
                if (answer.isCorrect == true) {
                    numberOfCorrectAnswers++;
                }
            }
            return numberOfCorrectAnswers;
        }


        //Class Answer for creating and keeping Answers
        protected class Answer {
            private String answerText;
            private boolean isCorrect;

            //Constructor
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
