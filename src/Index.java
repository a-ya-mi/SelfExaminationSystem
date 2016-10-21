
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedHashSet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Index extends JFrame {

    public static void main(String[] args) {
        TestData test = new TestData(1);
       //We create objekt from OurFrame (actually this is JFrame). This way we can put all JFrame Code into OurFrame, and not here. Or we can make some JFrames for later use
        JFrame jf = new OurFrame();
        
        

        System.out.println("The test name is: " + test.getTestName());
        System.out.println("The test description is: " + test.getTestDescription());

        System.out.println();

        System.out.println("ALL Questions in Random order");
        //Questions (to see what happend - System.out.println()
        LinkedHashSet<Integer> orderForQuestionsSet = randomOrder((test.getTheNumberOfQuestions() - 1));
        Iterator it = orderForQuestionsSet.iterator();
        int a;
        while (it.hasNext()) {
            a = (int) it.next();
            System.out.println(test.getQuestions().get(a).getQuestionText());
            getAnswerFromOneQuestionInRandomOrder(test.getQuestions().get(a));
            askAnswersFromUser(test.getQuestions().get(a));
        }

        System.out.println("__________________________");

        int i = 1;
        for (TestData.Question question : test.getQuestions()) {
            // We show the question and answers to a user
            System.out.println("Question " + i + ": " + question.getQuestionText());
            i++;
            int j = 1;
            for (TestData.Question.Answer answer : question.getAnswers()) {
                System.out.println(j + ". " + answer.getAnswerText());
                j++;
            }
            System.out.println("Write the numbers of correct answers: ");

        }
        
    }   

    static protected void askAnswersFromUser(TestData.Question q) {

        // We ask for answers from a User
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCorrectAnswers = q.numberOfCorrectAnswers();
        HashSet<Integer> previousCorrectAnswers = new HashSet<>(); // we keep here all correct answers that have already been named by User to prevent naming the same answer twice
        while (numberOfCorrectAnswers != 0) { // We prompt User for a number until all correct answers are selected
            // User enters a number (of answer)
            try { // surround with try-catch
                String answerUser = br.readLine();
                int answerInteger = Integer.parseInt(answerUser);
                //The system checks the answer and writes back
                if (q.getAnswers().get(answerInteger - 1).isCorrect() == true) { // if answer is correct. "answerInteger - 1" because we start from 0
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
static protected LinkedHashSet randomOrder(int size){
        LinkedHashSet<Integer> randomOrderSet= new LinkedHashSet<Integer>();

        Random rand = new Random();
        boolean bool=true;
        while (bool) {
            randomOrderSet.add(rand.nextInt(size));
            if(randomOrderSet.size()==size){
                bool=false;
            }     
        }
          return randomOrderSet;  
        }
     
     static protected void getAnswerFromOneQuestionInRandomOrder(TestData.Question q){
        //Answer from one Question in Random order  here. 
        //Later to go through EVERY answer whith this kode. Maybe separate Method willbe good here
        System.out.println("Answers for the one  Question in Random order");
        
        LinkedHashSet<Integer> orderForAnswersSet=randomOrder(q.getTheNumberOfAllAnswers());
        Iterator it2=orderForAnswersSet.iterator();
        int a2;
        while(it2.hasNext()){
            a2=(int)it2.next();
            System.out.println(q.getAnswers().get(a2).getAnswerText());
       }
     }
        
     
}
