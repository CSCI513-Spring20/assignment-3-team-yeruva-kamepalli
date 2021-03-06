import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci extends Task {

    public Fibonacci(int first, int last) {
        super("");
        FibinocciNum = new ArrayList<Integer>();
        this.first = first;
        this.last = last;
    } 
//    this method generates the fibonacci series upto nth number
    public static void fibinocci(int n) {  
    	FibinocciNum.clear();
    		 int t1 = 0, t2 = 1;
    	  

    	        for (int i = 1; i <= n; ++i)
    	        {
    	            
    	        	FibinocciNum.add(t1);
    	            int sum = t1 + t2;
    	            t1 = t2;
    	            t2 = sum;
    	        }    	   
    }
// Overides the super method to display the results  
    @Override
    public void run() {
    	 System.out.println(this.getTask() +"\t"+ Thread.currentThread().getName()+"started running");
         fibinocci(last);
         System.out.println( this.getTask() +"\t" +"Fibb numbers generated are: " + Arrays.toString(FibinocciNum.toArray()) );
         System.out.println( this.getTask() + "\t" + FibinocciNum.size() + " Fibb numbers generated by " + Thread.currentThread().getName()); 
    }
    // gets the input from the user upto which the fibb series has to be printed
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the upper bound of input range: ");
        int upper = input.nextInt();
        
 

        ThreadPooling threadPool = new ThreadPooling(10);
      
        int k = (int) Math.ceil(upper / 10); //calculates the no of tasks for single thread

        ArrayList<Fibonacci> tasks = new ArrayList<Fibonacci>();
        int lower = 0;

        for(int upperlimit = (lower + k); upperlimit <= upper; upperlimit = lower + k)
        {
            Fibonacci task = new Fibonacci(lower, upperlimit - 1);
           threadPool.taskexecution(task);
            tasks.add(task);
            lower = upperlimit;


        }
        threadPool.shutdown(); //ends the thread
        input.close();        
    }
    //Global variables
    private int first,last;
    private static ArrayList<Integer> FibinocciNum;
    String taskname;
    boolean isCompleted;
}
