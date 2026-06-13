import java.util.*;

class RoomNotAvailableException extends Exception {
    RoomNotAvailableException(String msg) {
        super(msg);
    }
}
interface Department{
    void getDeptData();
    void printDeptData();
}
class Hostel{
    Scanner sc=new Scanner(System.in);
    String hostelName;
    int numberofRooms;

    void getHostelData(){
        System.out.print("Enter the hostel name:");
        hostelName=sc.nextLine();

        System.out.print("Enter the number of rooms:");
        numberofRooms=sc.nextInt();
    }
    void printHostelData(){
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Number of Rooms: " + numberofRooms);        
    }
}

 class Student extends Hostel implements Department{
    int admNo;
    String studentName;
    String deptName;
    String programmeName;

    void getData() {
        System.out.print("Enter admission number: ");
        admNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter student name: ");
        studentName = sc.nextLine();
    }
    void printData() {
        System.out.println("Admission No: " + admNo);
        System.out.println("Student Name: " + studentName);
    }
    public void getDeptData(){
        System.out.print("Enter the dapartment name:");
        deptName=sc.nextLine();

        System.out.print("Enter programme name :");
        programmeName=sc.nextLine();
    }

    public void printDeptData() {
        System.out.println("Department: " + deptName);
        System.out.println("Programme: " + programmeName);
    }
    
    void hostelAdmission() throws RoomNotAvailableException{
        if(numberofRooms<=0){
            throw new RoomNotAvailableException("NO ROOM AVAILABLE");
        }
        numberofRooms--;
        System.out.println("Hostel admission successfull");
    }
}

public class Extra2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        while (true) {
            System.out.println("\n1.Admit Student");
            System.out.println("2.Hostel Admission");
            System.out.println("3.Display Student");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    s.getData();
                    s.getDeptData();
                    s.getHostelData();
                    break;

                case 2:
                    try {
                        s.hostelAdmission();
                    } catch (RoomNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    s.printData();
                    s.printDeptData();
                    s.printHostelData();
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}