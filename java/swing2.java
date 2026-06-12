import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing2 {
    public static void main(String[] args){

        JFrame frame = new JFrame("An event example");

        frame.setLayout(new FlowLayout());
        frame.setSize(320,220);
        JLabel label = new JLabel("Push a button");

        JButton okbutton=new JButton("OK");
        JButton cancelButton=new JButton("CANCEL");

        //ADDING ACTIONLISTENER TO OK BUTTON
        okbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                label.setText("OK pressed");
            }
        });

        //ADDING ACTIONLISTENER TO CANCEL BUTTON
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                label.setText("CANCEL pressed");
            }
        });

        //ADDING COMPONENTS TO FRAME
        frame.add(label);
        frame.add(okbutton);
        frame.add(cancelButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
