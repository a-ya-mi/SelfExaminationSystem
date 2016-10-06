import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;


public class Index {

    public static void main (String[] args) {
        TestData test = new TestData(1);

        System.out.println("The test name is: " + test.getTestName());
        System.out.println("The test description is: " + test.getTestDescription());

        System.out.println();

        int i = 1;
        for (TestData.Question question : test.getQuestions()) { // NO RANDOMIZING YET!!! TO DO.
            System.out.println("Question " + i + ": " + question.getQuestionText());
            i++;
            int j = 1;
            for (TestData.Question.Answer answer : question.getAnswers()) { // NO RANDOMIZING YET!!! TO DO.
                System.out.println(j + ". " + answer.getAnswerText());
                j++;
            }
            System.out.println("Write your answer under the line");
            System.out.println("______________________");
            System.out.println();
        }


/*
        //The user see the question
    System.out.println("TestData.Question: 2x2 is....");

    boolean answerFinal=false;
    //The user write the answer
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String answerUser = br.readLine();
    int answerInteger = Integer.parseInt(answerUser);
    //The system check the answer
    //The system write back
    if(answerInteger==4){
        answerFinal=true;
    }
    else{
        answerFinal=false;
    }

    System.out.println("Your answer is "+answerFinal);
    System.out.println("______________________");
*/
    }
}
