
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
    JLabel text;
    JLabel t;
    JButton buttonCheck;
    JButton buttonNext;
       
    public OurFrame(String description){
       setVisible(true);
       setSize(800,400);
       //always write ExitOnClose (if not, than Thread will stay open and never closes)  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setLocation(500, 250);  
       setTitle("Self Examination System");
       setResizable(false);
       setLayout(null);
       
       text = new JLabel(description);
       //to see the Text inside we use Bounds
       text.setBounds(120,7,500,22);
       Font schrift = new Font ("Serif", Font.BOLD + Font.ITALIC, 22);
       text.setFont(schrift);
       add(text);
        
       
       buttonCheck = new JButton("Check the answer");
       buttonCheck.setBounds(50,300,200,22);
       add(buttonCheck); 
       
       
       buttonNext = new JButton("Next question");
       buttonNext.setBounds(350,300,200,22);
       buttonNext.addActionListener(new UnserListener());
       add(buttonNext);
        
    }
    
    
   
    
    
    private class UnserListener implements ActionListener {
    
        @Override
        public void actionPerformed(ActionEvent ae) {
            text.setText("Yo!");
        }
    
    } 
    
}
