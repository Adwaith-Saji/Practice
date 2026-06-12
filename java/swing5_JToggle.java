import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class swing5_JToggle extends JFrame implements ItemListener {
    JFrame jfrm;
    JToggleButton jtbn;
    JLabel jlab;

    swing5_JToggle(){
        jfrm=new JFrame("Simple Swing");
        jfrm.setSize(500,400);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtbn=new JToggleButton("On/Off");  
        jtbn.addItemListener(this);  
        jfrm.add(jtbn);
        jlab = new JLabel("Button is OFF");  
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ie){
        if(jtbn.isSelected())
            jlab.setText("Button is on");
        else
            jlab.setText("Button is off");
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new swing5_JToggle();
            }
        });
    }
    
}
