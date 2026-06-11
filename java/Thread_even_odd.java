import java.util.Scanner;

class GenerateThread extends Thread{
    public void run() {

        Scanner sc=new Scanner(System.in);
        int n = (int)(Math.random() * 100) + 1;
        System.out.println("Generated number: " + n);

        if (n%2==0){
            EvenThread t1=new EvenThread(n);
            t1.start();
        }
        else{
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
        for(int i=2;i<=n;i+=2){
            System.out.println(i);
        }
    }
}
class OddThread extends Thread {
    int n;
    OddThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i += 2) {
            System.out.println(i);
        }
    }
}

public class Thread_even_odd {

    public static void main(String[] args){
        while(true){
            GenerateThread n=new GenerateThread();
            n.start();
            try{
                    Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
}