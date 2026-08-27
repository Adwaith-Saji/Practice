import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class LightPanel extends JPanel {
    Color lightColor = Color.RED;

    public void setLightColor(Color c) {
        lightColor = c;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(lightColor);
        g.fillOval(20, 20, 50, 50); // Circular light
    }
}

public class EXTRAA_b extends JFrame implements ActionListener {

    JTextField tfFile, tfChar, tfLine, tfWord;
    JButton btnCheck;
    LightPanel light;

    public EXTRAA_b() {

        setTitle("File Checker");
        setSize(500, 500);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("File Name:"));
        tfFile = new JTextField();
        add(tfFile);

        add(new JLabel("Characters:"));
        tfChar = new JTextField();
        add(tfChar);

        add(new JLabel("Lines:"));
        tfLine = new JTextField();
        add(tfLine);

        add(new JLabel("Words:"));
        tfWord = new JTextField();
        add(tfWord);

        light = new LightPanel();
        add(light);

        btnCheck = new JButton("Check File");
        btnCheck.addActionListener(this);
        add(btnCheck);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String fileName = tfFile.getText();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            int chars = 0;
            int lines = 0;
            int words = 0;

            String line;

            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();

                String[] w = line.trim().split("\\s+");

                if (!line.trim().isEmpty())
                    words += w.length;
            }

            br.close();

            light.setLightColor(Color.GREEN);

            tfChar.setText(String.valueOf(chars));
            tfLine.setText(String.valueOf(lines));
            tfWord.setText(String.valueOf(words));

        } catch (FileNotFoundException ex) {

            light.setLightColor(Color.RED);
            tfFile.setText("File Not Found");

            tfChar.setText("");
            tfLine.setText("");
            tfWord.setText("");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EXTRAA_b();
    }
}