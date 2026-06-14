import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Extra6_GUI extends JFrame implements ActionListener, ChangeListener {

    JComboBox<String> timeBox;
    JSlider brightness;
    JLabel result;

    Extra6_GUI() {
        setTitle("Street Light Simulation");
        setSize(400, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String t[] = {"Morning", "Evening", "Night"};
        timeBox = new JComboBox<>(t);

        brightness = new JSlider(0, 100, 50);
        brightness.setMajorTickSpacing(20);
        brightness.setPaintTicks(true);
        brightness.setPaintLabels(true);

        result = new JLabel("Street Light Status: OFF");

        add(new JLabel("Select Time of Day:"));
        add(timeBox);

        add(new JLabel("Brightness Level:"));
        add(brightness);

        add(result);

        timeBox.addActionListener(this);
        brightness.addChangeListener(this);

        setVisible(true);
    }

    public void checkLight() {
        String time = (String) timeBox.getSelectedItem();
        int b = brightness.getValue();

        if (time.equals("Evening") || time.equals("Night") || b < 40) {
            result.setText("Street Light Status: ON");
        } else {
            result.setText("Street Light Status: OFF");
        }
    }

    public void actionPerformed(ActionEvent e) {
        checkLight();
    }

    public void stateChanged(ChangeEvent e) {
        checkLight();
    }

    public static void main(String args[]) {
        new Extra6_GUI();
    }
}