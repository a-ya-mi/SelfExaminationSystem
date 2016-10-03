
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

/**
 * Created by Aksana on 02.10.2016.
 */
public class Index {

    public static void main (String[] args)throws IOException{

        //The user see the question
    System.out.println("Question: 2x2 is....");
    System.out.println("Write your answer under the line");
    System.out.println("______________________");

    boolean answerFinal=false;
    //The user write the answer
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String answerUser = br.readLine();
    int answerInteger = Integer.parseInt(answerUser);
    //The system check the users answer
    //The system write back
    if(answerInteger==4){
        answerFinal=true;
    }
    else{
        answerFinal=false;
    }

    System.out.println("Your answer is "+answerFinal);
    System.out.println("______________________");
}
}
