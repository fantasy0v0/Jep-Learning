package jep_learning.jep444;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

/**
 * @author fan 2026/1/9
 */
public class Jep444Test {

  @Test
  void testThreadLocal() throws InterruptedException {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    threadLocal.set("main");
    InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    inheritableThreadLocal.set("main");
    Runnable task = () -> {
      String msg = threadLocal.get();
      System.out.printf("child msg: %s%n", msg);
      threadLocal.set("child");

      String msg1 = inheritableThreadLocal.get();
      System.out.printf("child inheritable msg: %s%n", msg1);
      inheritableThreadLocal.set("child");
      msg1 = inheritableThreadLocal.get();
      System.out.printf("child inheritable msg: %s%n", msg1);
    };
    Thread.ofVirtual().start(task).join();
    String msg = inheritableThreadLocal.get();
    System.out.printf("main inheritable msg: %s%n", msg);
    Thread.ofVirtual().start(task).join();
    msg = inheritableThreadLocal.get();
    System.out.printf("main inheritable msg: %s%n", msg);
  }

}
