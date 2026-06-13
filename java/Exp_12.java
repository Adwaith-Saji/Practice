import java.util.Random;

class GenerateNumber extends Thread{
    public void run(){
        Random r=new Random();
        int n=r.nextInt(100);

        if(n%2==0){
            EvenThread t1=new EvenThread(n);
            t1.start();
        }
        else if(n%2!=0){
            OddThread t2=new OddThread(n);
            t2.start();
        }
    }
}
class EvenThread extends Thread{
    int n;
    EvenThread(int n){
        this.n=n;
    }
    public void run(){
        System.out.println("Even Thread : "+(n*n));
    }
}
class OddThread extends Thread{
    int n;
    OddThread(int n){
        this.n=n;
    }
    public void run(){
        System.out.println("Odd Thread : "+(n*n*n));
    }
}

public class Exp_12 {
    public static void main(String args[]){
    while(true){
        GenerateNumber g=new GenerateNumber();
        g.start();
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("Exception occured");
        }
    }
    }
}