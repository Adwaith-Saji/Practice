import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LightPanel extends JPanel {
    Color red = Color.GRAY;
    Color yellow = Color.GRAY;
    Color green = Color.GRAY;

    public void setLight(String c) {
        red = Color.GRAY;
        yellow = Color.GRAY;
        green = Color.GRAY;

        if (c.equals("red"))
            red = Color.RED;
        else if (c.equals("yellow"))
            yellow = Color.YELLOW;
        else if (c.equals("green"))
            green = Color.GREEN;

        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRoundRect(70, 20, 120, 250, 20, 20);

        g.setColor(red);
        g.fillOval(100, 40, 60, 60);

        g.setColor(yellow);
        g.fillOval(100, 115, 60, 60);

        g.setColor(green);
        g.fillOval(100, 190, 60, 60);
    }
}

public class traffic_light2 extends JFrame implements ActionListener {
    JRadioButton r, y, g;
    LightPanel p;

    traffic_light2() {
        setTitle("Traffic Light Simulator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new LightPanel();

        r = new JRadioButton("RED");
        y = new JRadioButton("YELLOW");
        g = new JRadioButton("GREEN");

        ButtonGroup bg = new ButtonGroup();
        bg.add(r);
        bg.add(y);
        bg.add(g);

        r.addActionListener(this);
        y.addActionListener(this);
        g.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(r);
        buttonPanel.add(y);
        buttonPanel.add(g);

        add(p, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (r.isSelected())
            p.setLight("red");
        else if (y.isSelected())
            p.setLight("yellow");
        else if (g.isSelected())
            p.setLight("green");
    }

    public static void main(String[] args) {
        new traffic_light2();
    }
}
