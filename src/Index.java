import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Iterator;
import java.util.Set;

public class Index {

    public static void main (String[] args) {
        TestData test = new TestData(1);

        System.out.println("The test name is: " + test.getTestName());
        System.out.println("The test description is: " + test.getTestDescription());

        System.out.println();
        
        
        System.out.println("ALL Questions in Random order");
        //Ramdom numbers in Set (HasSet of Integers). This way put Questions will not repeat
        Set<Integer> orderForQuestionsSet= new HashSet<Integer>();

        Random rand = new Random();
        boolean bool=true;
        while (bool) {
            if(orderForQuestionsSet.size()==(test.getTheNumberOfQuestions()-1)){
                bool=false;
            }
            orderForQuestionsSet.add((rand.nextInt(test.getTheNumberOfQuestions())));
        }
        
        Iterator it=orderForQuestionsSet.iterator();
        int a;
        //Questions in really Random order
        //TODO - the number of Question changed itself (because of use Iterator.next()). Sometimes one Question goes loos
        while(it.hasNext()){
                a=(int)it.next();
                System.out.println(test.getQuestions().get(a).getQuestionText());
            }
        
        System.out.println();
        System.out.println();
        
        
        
        //Answer from one Question in Random order TODO here
       
        int i = 1;
        for (TestData.Question question : test.getQuestions()) { // NO RANDOMIZING YET!!! TO DO.
            // We show the question and answers to a user
            System.out.println("Question " + i + ": " + question.getQuestionText());
            i++;
            int j = 1;
                for (TestData.Question.Answer answer : question.getAnswers()) { // NO RANDOMIZING YET!!! TO DO.
                    System.out.println(j + ". " + answer.getAnswerText());
                    j++;
                }
            System.out.println("Write the numbers of correct answers: ");


            // We ask for answers from a User
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int numberOfCorrectAnswers = question.numberOfCorrectAnswers();
            HashSet<Integer> previousCorrectAnswers = new HashSet<>(); // we keep here all correct answers that have already been named by User to prevent naming the same answer twice
            while (numberOfCorrectAnswers != 0) { // We prompt User for a number until all correct answers are selected
                // User enters a number (of answer)
                try { // surround with try-catch
                    String answerUser = br.readLine();
                    int answerInteger = Integer.parseInt(answerUser);
                    //The system checks the answer and writes back
                    if(question.getAnswers().get(answerInteger-1).isCorrect() == true){ // if answer is correct. "answerInteger - 1" because we start from 0
                        if (previousCorrectAnswers.contains(answerInteger-1)) { // User already chose this answer before
                            System.out.println("answer is correct but you've already chosen it before");
                        } else {
                            System.out.println("answer is correct");
                            previousCorrectAnswers.add(answerInteger - 1);
                            numberOfCorrectAnswers--;
                        }
                    }
                    else{
                        System.out.println("answer is wrong");
                    }
                } catch (Exception  e) {
                    System.out.println("Oops! Try again");
                }
            }
            System.out.println();
            System.out.println("NEXT Question");
        }

   }
}
