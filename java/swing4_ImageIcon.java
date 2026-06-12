import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class swing4_ImageIcon extends JFrame implements ActionListener{
    JLabel jlab;
    swing4_ImageIcon(){
        JFrame jfrm=new JFrame("Simple Swing");
        jfrm.setSize(500,400);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon imgok=new ImageIcon("C:\\Users\\ADWAITH SAJI\\OneDrive\\Documents\\Practice_1\\Practice\\java\\Screenshot (20).png");
        Image img = imgok.getImage();               //optional
        Image scaled = img.getScaledInstance(100, 50, Image.SCALE_SMOOTH);      //optional
        imgok = new ImageIcon(scaled);                 //optional
        JButton jbok=new JButton(imgok);
        jbok.setActionCommand("OK");
        jfrm.add(jbok);

        JButton jbcancel = new JButton("CANCEL");
        jbcancel.setActionCommand("CANCEL");
        jfrm.add(jbcancel);

        jbok.addActionListener(this);
        jbcancel.addActionListener(this);

        jlab=new JLabel("Waiting button press");
        jfrm.add(jlab);
        jfrm.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        jlab.setText("You Selected "+ ae.getActionCommand());
    }
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new swing4_ImageIcon();
            }
        });
    }
}