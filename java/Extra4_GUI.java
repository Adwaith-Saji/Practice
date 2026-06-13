import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class Extra4_GUI extends JFrame implements ActionListener{

    JTextField t1,t2,t3,t4,t5;
    JTextArea area;
    JButton add,view,update;

    Extra4_GUI(){
        setTitle("Student Details");
        setSize(500,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(new JLabel("Roll No"));
        t1=new JTextField(15);
        add(t1);

        add(new JLabel("Name"));
        t2 = new JTextField(15);
        add(t2);        

        add(new JLabel("Mark1"));
        t3 = new JTextField(15);
        add(t3);

        add(new JLabel("Mark2"));
        t4 = new JTextField(15);
        add(t4);

        add(new JLabel("Mark3"));
        t5 = new JTextField(15);
        add(t5);

        add=new JButton("ADD");
        view=new JButton("VIEW");
        update=new JButton("UPDATE");

        add(add);
        add(view);
        add(update);

        add.addActionListener(this);
        view.addActionListener(this);
        update.addActionListener(this);

        area = new JTextArea(15,35);
        add(new JScrollPane(area));

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            try{
                int m1=Integer.parseInt(t3.getText());
                int m2=Integer.parseInt(t4.getText());
                int m3=Integer.parseInt(t5.getText());

                int total=m1+m2+m3;

                FileWriter fw=new FileWriter("students.txt",true);
                fw.write(t1.getText() + "," + t2.getText() + "," +
                        m1 + "," + m2 + "," + m3 + "," + total + "\n");
                fw.close();

                area.setText("Student added successfully");
                
            }catch(Exception e){
                area.setText("ERROR");
            }
        }

        if(ae.getSource()==view){
            try{
                FileReader fr=new FileReader("students.txt");
                BufferedReader br=new BufferedReader(fr);
                String s;
                area.setText("");

                while((s=br.readLine())!=null){
                    area.append(s+"\n");
                }
                br.close();
            }catch(Exception ex){
                area.setText("File ERROR");
            }
        }
        if (ae.getSource() == update) {
            try {
                File file = new File("students.txt");
                ArrayList<String> list = new ArrayList<>();

                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    String data[] = line.split(",");

                    if (data[0].equals(t1.getText())) {
                        int m1 = Integer.parseInt(t3.getText());
                        int m2 = Integer.parseInt(t4.getText());
                        int m3 = Integer.parseInt(t5.getText());
                        int total = m1 + m2 + m3;

                        line = t1.getText() + "," + t2.getText() + "," +
                                m1 + "," + m2 + "," + m3 + "," + total;
                    }
                    list.add(line);
                }
                br.close();

                FileWriter fw = new FileWriter(file);
                for (String x : list) {
                    fw.write(x + "\n");
                }
                fw.close();

                area.setText("Updated Successfully");

            } catch (Exception ex) {
                area.setText("Update Error");
            }
        }

    }
    public static void main(String args[]) {
        new Extra4_GUI();
    }
}

