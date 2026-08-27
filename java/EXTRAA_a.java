import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EXTRAA_a extends JFrame implements ActionListener {

    JTextField tfInput, tfEven, tfOdd;
    JButton btnEven, btnOdd;

    public EXTRAA_a() {

        setTitle("Even and Odd Sum");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Enter Integers (comma separated):"));
        tfInput = new JTextField();
        add(tfInput);

        add(new JLabel("Sum of Even Numbers:"));
        tfEven = new JTextField();
        tfEven.setEditable(false);
        add(tfEven);

        add(new JLabel("Sum of Odd Numbers:"));
        tfOdd = new JTextField();
        tfOdd.setEditable(false);
        add(tfOdd);

        btnEven = new JButton("Even");
        btnOdd = new JButton("Odd");

        add(btnEven);
        add(btnOdd);

        btnEven.addActionListener(this);
        btnOdd.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String input = tfInput.getText();
        String[] numbers = input.split(",");

        int evenSum = 0;
        int oddSum = 0;

        for (String num : numbers) {
            int n = Integer.parseInt(num.trim());

            if (n % 2 == 0)
                evenSum += n;
            else
                oddSum += n;
        }

        if (e.getSource() == btnEven) {
            tfEven.setText(String.valueOf(evenSum));
        }

        if (e.getSource() == btnOdd) {
            tfOdd.setText(String.valueOf(oddSum));
        }
    }

    public static void main(String[] args) {
        new EXTRAA_a();
    }
}