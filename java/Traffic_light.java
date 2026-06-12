import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Traffic_light extends JFrame implements ActionListener {
    JRadioButton r,y,g;
    JPanel p1,p2,p3;

    Traffic_light(){
        setTitle("Traffic LLight Simulator");
        setSize(300,400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();

        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.GRAY);
        p3.setBackground(Color.GRAY);

        p1.setPreferredSize(new Dimension(100, 80));
        p2.setPreferredSize(new Dimension(100, 80));
        p3.setPreferredSize(new Dimension(100, 80));

        JPanel lightPanel=new JPanel();
        lightPanel.setLayout(new GridLayout(3,1,5,5));
        lightPanel.add(p1);
        lightPanel.add(p2);
        lightPanel.add(p3);

        r=new JRadioButton("RED");
        y=new JRadioButton("YELLOW");
        g=new JRadioButton("GREEN");

        ButtonGroup bg=new ButtonGroup();
        bg.add(r);
        bg.add(y);
        bg.add(g);

        r.addActionListener(this);
        y.addActionListener(this);
        g.addActionListener(this);

        JPanel buttonPanel=new JPanel();
        buttonPanel.add(r);
        buttonPanel.add(y);
        buttonPanel.add(g);

        add(lightPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.GRAY);
        p3.setBackground(Color.GRAY);
  
        if(r.isSelected())
            p1.setBackground(Color.RED);
        else if(y.isSelected())
            p2.setBackground(Color.YELLOW);
        else if(g.isSelected())
            p3.setBackground(Color.GREEN);
    }
    public static void main(String[] args) {
        new Traffic_light();
    }
    
}
