
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Index extends JFrame {

    public static void main(String[] args) {
        TestData test = new TestData(1);
       //We create objekt from OurFrame (actually this is JFrame). This way we can put all JFrame Code into OurFrame, and not here. Or we can make some JFrames for later use
        String description="The test name is: " + test.getTestName();
        JFrame jf = new OurFrame(description);
      
        
       String description2="The test description is: " + test.getTestDescription();
       System.out.println();

        //Questions (to see what happend - System.out.println()
        LinkedHashSet<Integer> orderForQuestionsSet = randomOrder((test.getTheNumberOfQuestions() - 1));
        Iterator it = orderForQuestionsSet.iterator();
        int a;
        while (it.hasNext()) {
            a = (int) it.next();
            TestData.Question currentQuestion = test.getQuestions().get(a);
            System.out.println(currentQuestion.getQuestionText());
            LinkedHashSet<Integer> orderForAnswersSet = randomOrder(currentQuestion.getTheNumberOfAllAnswers());
            showAnswersForCurrentQuestionInRandomOrder(currentQuestion, orderForAnswersSet);
            askUserForAnswers(currentQuestion, new ArrayList<Integer>(orderForAnswersSet));
        }

        System.out.println("__________________________");

    }

    static protected void askUserForAnswers(TestData.Question q, ArrayList<Integer> orderForAnswersList) {
        // We ask for answers from a User
        System.out.println("Write the numbers of correct answers: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCorrectAnswers = q.numberOfCorrectAnswers();
        HashSet<Integer> previousCorrectAnswers = new HashSet<>(); // we keep here all correct answers that have already been named by User to prevent naming the same answer twice
        while (numberOfCorrectAnswers != 0) { // We prompt User for a number until all correct answers are selected
            // User enters a number (of answer)
            try { // surround with try-catch
                String answerUser = br.readLine();
                int answerInteger = Integer.parseInt(answerUser);
                //The system checks the answer and writes back
                if (q.getAnswers().get(orderForAnswersList.get(answerInteger - 1)).isCorrect() == true) { // if answer is correct. "answerInteger - 1" because we start from 0
                    if (previousCorrectAnswers.contains(answerInteger - 1)) { // User already chose this answer before
                        System.out.println("answer is correct but you've already chosen it before");
                    } else {
                        System.out.println("answer is correct");
                        previousCorrectAnswers.add(answerInteger - 1);
                        numberOfCorrectAnswers--;
                    }
                } else {
                    System.out.println("answer is wrong");
                }
            } catch (Exception e) {
                System.out.println("Oops! Try again");
            }
        }
        System.out.println();
        System.out.println("NEXT Question");
    }


    //Method to become Set with Random Order. Use for Question Order. Use for Answers Order
    static protected LinkedHashSet randomOrder(int size) {
        LinkedHashSet<Integer> randomOrderSet = new LinkedHashSet<Integer>();

        Random rand = new Random();
        boolean bool = true;
        while (bool) {
            randomOrderSet.add(rand.nextInt(size));
            if (randomOrderSet.size() == size) {
                bool = false;
            }
        }
        return randomOrderSet;
    }

    static protected void showAnswersForCurrentQuestionInRandomOrder(TestData.Question q, LinkedHashSet<Integer> orderForAnswersSet) {
        //Answer from one Question in Random order  here. 
        //Later to go through EVERY answer whith this kode. Maybe separate Method willbe good here

        Iterator it2 = orderForAnswersSet.iterator();
        int a2;
        int questionNumberForUser = 1;
        while (it2.hasNext()) {
            a2 = (int) it2.next();
            System.out.println(questionNumberForUser + ": " + q.getAnswers().get(a2).getAnswerText());
            questionNumberForUser++;
        }
    }
}
