import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class swing3 extends JFrame implements ActionListener {
    JLabel jlab;
    swing3(){
        JFrame jfrm=new JFrame("An Event Example");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(220,90);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton jbtnok=new JButton("OK");
        JButton jbtncancel=new JButton("CANCEL");
        jbtnok.setToolTipText("click");
        jbtnok.addActionListener(this);
        jbtncancel.addActionListener(this);
        jfrm.add(jbtnok);
        jfrm.add(jbtncancel);
        jlab=new JLabel("Press a button");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            String s=ae.getActionCommand();
            if(s.equalsIgnoreCase("ok"))
                jlab.setText("OK pressed");
            else if(s.equalsIgnoreCase("cancel"))
                jlab.setText("CANCEL pressed");
        }
        public static void main(String args[]){

                    new swing3();
                }
        
}   
    

