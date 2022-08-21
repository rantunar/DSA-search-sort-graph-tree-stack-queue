import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

  int i=1;
  public static void main(String[] args) {
    ThreadTest threadTest = new ThreadTest();
    ExecutorService executorService = null;
    try {
      executorService = Executors.newFixedThreadPool(2);
      executorService.execute(new Thread(() -> {
        threadTest.printNumbers(0);
      }));
      executorService.execute(new Thread(() -> {
        threadTest.printNumbers(1);
      }));
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      if(executorService != null) executorService.shutdown();
    }
  }

  public void printNumbers(int n) {
    synchronized (this) {
      while (i <= 10) {
        while (i % 2 != n) {
          try {
            wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName() +" "+ i++);
        notifyAll();
      }
    }
  }
}
