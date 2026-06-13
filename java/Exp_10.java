import java.io.*;

public class Exp_10 {
    public static void main(String args[]){
        FileInputStream a=null;
        FileOutputStream b=null;

        try{
            a=new FileInputStream("input.txt");
            b=new FileOutputStream("output.txt");
            int c;
            while((c=a.read())!=-1){
                b.write(c);
            }
            System.out.println("File copied successfully");
        }catch(FileNotFoundException e){
            System.out.println("File not Found");
        }catch(IOException e){
            System.out.println("Error in file processing");
        }finally{
            try{
                if(a!=null)
                    a.close();
                if(b!=null)
                    b.close();
        }catch(IOException e){
            System.out.println("Error closing file");
        }
    }
}
}