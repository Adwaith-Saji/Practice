import java.util.Scanner;


class InvalidAgeException extends Exception{
    InvalidAgeException(String msg){
        super(msg);
    }
}
public class user_defined_exception{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter your age:");
            int age=sc.nextInt();

            if(age<18){
                throw new InvalidAgeException("You must be 18 years old or above");
            }
            System.out.println("Eligible");
        }catch(InvalidAgeException e){
            System.out.println("Exception : "+e.getMessage());
        }
    }
}