import java.util.*;

class BankAccount{
    Scanner sc=new Scanner(System.in);
    float bal=0;
    void deposit(){
        System.out.print("Enter the amount to deposit:");
        float dep=sc.nextFloat();
        bal+=dep;
        System.out.print("Money deposited:"+dep);
    }
    void withdraw(){
        System.out.print("Enter the amount to withdraw:");
        float wd=sc.nextFloat();
        if(bal<wd){
            System.out.print("Sorry no sufficient balance");
        }
        else{
            bal-=wd;
            System.out.println("Money withdrawn:"+wd);
        }
    }
}
class SavingAccount extends BankAccount{
    void withdraw(){
        System.out.print("Enter the amount to withdraw:");
        float wd2=sc.nextFloat();

        if((bal-wd2)<100){
            System.out.print("Sorry, cannot withdraw amount as the minimum balance is 100");
        }
        else{
            bal-=wd2;
            System.out.println("Money withdrawn: " + wd2);

        }
    }
}
class Extra1 {
    public static void main(String args[]) {
        SavingAccount s = new SavingAccount();

        s.deposit();
        s.withdraw();
    }
}