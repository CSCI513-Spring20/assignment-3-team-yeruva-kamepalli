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
  
    @Override
    public void run() {
       
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the upper bound of input range: ");
        int upper = input.nextInt();
        
 

        ThreadPooling threadPool = new ThreadPooling(10);
      
        int k = (int) Math.ceil(upper / 10);

        ArrayList<Fibonacci> tasks = new ArrayList<Fibonacci>();
        int lower = 0;

        for(int upperlimit = (lower + k); upperlimit <= upper; upperlimit = lower + k)
        {
            Fibonacci task = new Fibonacci(lower, upperlimit - 1);
           threadPool.taskexecution(task);
            tasks.add(task);
            lower = upperlimit;


        }
        threadPool.shutdown();
        input.close();
    }
    private int first,last;
    private static ArrayList<Integer> FibinocciNum;
    String taskname;
    boolean isCompleted;
}
