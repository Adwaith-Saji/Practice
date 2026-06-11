import javax.swing.*;

public class swing1 {
    public static void main(String[] args){
        JFrame frame=new JFrame("Simple Swing Example");
        JLabel label=new JLabel("Welcome to java swing");

        frame.add(label);
        frame.setSize(300,200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
