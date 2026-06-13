import java.util.*;

public class Exp_8 {
    static void checkAge(int age){
        if(age<18){
            throw new ArithmeticException("Not eligible to vote");
        }
        else{
            System.out.println("Eligible to vote");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        try{
            System.out.print("ENter a number :");
            int num1=sc.nextInt();
            
            System.out.print("Enter another number:"); 
            int num2=sc.nextInt();

            int result=num1/num2;
            System.out.println("Result:"+result);

            System.out.print("Enter your age:");
            int age=sc.nextInt();

            checkAge(age);
        }catch(ArithmeticException e){
            System.out.println("Exception caught: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Some other exception occurred");
        }
        finally {
            System.out.println("Finally block always executes");
            sc.close();
        }
    }
    
}
