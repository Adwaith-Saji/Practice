class mul2 extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(i+" x "+2+" = "+i*2);
        }
    }
}
class mul5 extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(i+" x "+5+" = "+i*5);
        }
    }    
}
class mul10 extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(i+" x "+10+" = "+i*10);
        }
    }    
}

public class Extra3{
    public static void main(String[] args){
        mul2 t1=new mul2();
        mul5 t2=new mul5();
        mul10 t3=new mul10();
        try{
            t1.start();
            t1.join() ;
            t2.start();
            t2.join() ;
            t3.start();
            t3.join() ;

        }catch(InterruptedException e){
            System.out.println("Error:"+e);
        }
}}