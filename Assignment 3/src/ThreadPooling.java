import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
public class ThreadPooling {
    final int count;
    public  boolean close = false;
    private final LinkedBlockingQueue<Task> L  = new LinkedBlockingQueue<Task>();
    private final ArrayList<Task> Tottask = new ArrayList<Task>();
    private final PerformanceTask[] task;
    public ThreadPooling(int Size){
        this.count = Size;
        task = new PerformanceTask[this.count];
        int m =0;
        while ( m < Size) {
            task[m] = new PerformanceTask("Thread " + m);
            task[m].start();
            m++;
        }
    }

    public void taskexecution(Task task) {
        synchronized (L) {
            L.add(task);
            L.notify();
        }
    }
    public void shutdown() {
        this.close = true;
    }

    private class PerformanceTask extends Thread {
        public PerformanceTask(String name)
        {
            super(name);
        }
        @Override
        public void run() {
           
        }
    }

}
abstract class Task implements Runnable{
    String taskname;
    boolean isCompleted;

    public Task(String taskname) {
        this.taskname = taskname;
        this.isCompleted = false;
    }

    public String getTask() {
        return taskname;
    }

    public void setIsCompleted() {
        isCompleted = true;
    }
}