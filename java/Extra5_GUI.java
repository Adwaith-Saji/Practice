import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Extra5_GUI extends JFrame implements ActionListener{
    JTextField t;
    JButton b;
    JLabel l;
    int n;

    Extra5_GUI(){
        Random r=new Random();
        n=r.nextInt(100)+1;

        setTitle("Number Guessing Game");
        setSize(400,200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l=new JLabel("Guess a number(1-100)");
        t=new JTextField(10);
        b=new JButton("CHECK");

        add(l);
        add(t);
        add(b);

        b.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            int g=Integer.parseInt(t.getText());

            if(g>n){
                l.setText("TOO HIGH!");
            }
            else if(g<n){
                l.setText("TOO LOW!");
            }
            else{
                l.setText("CORRECT!!!");
            }
        }catch(Exception e){
            l.setText("Enter valid number");
        }
    }
    public static void main(String args[]){
        new Extra5_GUI();
    }

}