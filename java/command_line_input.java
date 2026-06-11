class AvgException extends Exception {
    AvgException(String msg){
        super(msg);
    }
}

public class command_line_input {

    public static void main(String args[]){
        int sum=0;
        try{
            for(int i=0;i<args.length;i++){
                sum+=Integer.parseInt(args[i]);
            }
            
            double avg=sum/args.length;

            if (avg>100){
                throw new AvgException("Invalid average, average cant exceed 100");

            }
        }catch(AvgException e){
            System.out.println("Exception : "+e.getMessage() );
        }
    }
}