
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aksana
 */
public class OurFrame extends JFrame{
    JLabel textQuestion;
    JLabel textAnswers;
    JLabel t;
    JButton buttonCheck;
    JButton buttonNext;
    JTextField eingabe;   
    
    public OurFrame(String description){
       setSize(800,400);
       //always write ExitOnClose (if not, than Thread will stay open and never closes)  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setLocation(500, 250);  
       setTitle("Self Examination System");
       setResizable(false);
       setLayout(null);
       
       textQuestion = new JLabel(description);
       //to see the Text inside we use Bounds
       textQuestion.setBounds(120,7,500,22);
       Font schrift = new Font ("Serif", Font.BOLD + Font.ITALIC, 22);
       textQuestion.setFont(schrift);
       add(textQuestion);
        
       textAnswers = new JLabel("Answers and their numbers");
       //to see the Text inside we use Bounds
       textAnswers.setBounds(10,40,500,22);
       Font schrift2 = new Font ("Serif", Font.PLAIN, 20);
       textAnswers.setFont(schrift2);
       add(textAnswers);
       
       buttonCheck = new JButton("Check the answer");
       buttonCheck.setBounds(50,300,200,22);
       buttonCheck.addActionListener(new UnserListener());
       add(buttonCheck); 
       
       buttonNext = new JButton("Next question");
       buttonNext.setBounds(350,300,200,22);
       add(buttonNext);
        
       eingabe = new JTextField();
       eingabe.setBounds(10,80,500,50);
       add(eingabe);
       
       setVisible(true);
    }
    
    
   
    
    
    private class UnserListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent ae) {
            String s = eingabe.getText();
            textAnswers.setText("Your answers were - " + s);
        }
    
    } 
    
}
