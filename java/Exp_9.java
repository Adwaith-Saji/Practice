import java.io.*;

public class Exp_9 {
    public static void main(String[] args) throws IOException{
        FileReader f=new FileReader("input.txt");
        BufferedReader b=new BufferedReader(f);
        int c=0,w=0,l=0;
        String s;
        while ((s=b.readLine())!=null) {
            l++;
            c+=s.length();
            String a[]=s.split(" ");
            w+=a.length;
        }
        b.close();
        System.out.println("Characters:"+c);
        System.out.println("Words:"+w);
        System.out.println("Lines:"+l);
        
    }
}
