class Shared {
    int n=1;

    synchronized void print3(){
        for(;n<=30;){
            if(n%3==0){
                System.out.println("Thread A : "+n);
                n++;
                notifyAll();
            }else{
                try{
                    wait();
                }catch(Exception e){
                }
            }
        }
    }
    synchronized void print5(){
        for(;n<=30;){
            if(n%5==0 && n%3!=0)   {            
                System.out.println("Thread B : "+n);
                n++;
                notifyAll();
            }else{
                try{
                    wait();
                }catch(Exception e){}
            }
        }
    }
    synchronized void printOther(){
        for(;n<=30;){
            if(n%3!=0 && n%5!=0){
                System.out.println("THread C : "+n);
                n++;
                notifyAll();
            }else{
                try{
                    wait();
                }catch(Exception e){}
            }
        }
    }
}

class A extends Thread {
    Shared s;
    A(Shared s){
        this.s=s;
    }

    public void run(){
        s.print3();
    }
}
class B extends Thread{
    Shared s;
    B(Shared s){
        this.s=s;
    }
    public void run(){
        s.print5();
    }
}
class C extends Thread{
    Shared s;
    C(Shared s){
        this.s=s;
    }
    public void run(){
        s.printOther();
    }
}
public class Q4 {
    public static void main(String[] args){
        Shared s=new Shared();

        A t1=new A(s);
        B t2=new B(s);
        C t3=new C(s);

        t1.start();
        t2.start();
        t3.start();
    }
}