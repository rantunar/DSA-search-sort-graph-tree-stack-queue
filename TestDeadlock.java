import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDeadlock {

  public static void main(String[] args) {

    String resource1 = "kk";
    String resource2 = "java";
    ExecutorService executorService = null;

    try {
      executorService = Executors.newFixedThreadPool(2);
      executorService.execute(new Thread(() -> {
        synchronized (resource1) {
          System.out.println(Thread.currentThread().getName() + " - Locked on resource1");
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (resource2) {
            System.out.println(Thread.currentThread().getName() + " - Locked on resource2");
          }
        }
      }));

      executorService.execute(new Thread(() -> {
        synchronized (resource2) {
          System.out.println(Thread.currentThread().getName() + " - Locked on resource2");
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (resource1) {
            System.out.println(Thread.currentThread().getName() + " - Locked on resource1");
          }
        }
      }));
    }catch(Exception e){
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }
  }
}
